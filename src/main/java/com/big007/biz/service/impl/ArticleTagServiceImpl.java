package com.big007.biz.service.impl;

import com.big007.biz.entity.SysArticleTag;
import com.big007.biz.mapper.ArticleTagMapper;
import com.big007.biz.service.ArticleTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, SysArticleTag> implements ArticleTagService {

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    @Transactional
    public void add(SysArticleTag sysArticleTag) {
        if (!exists(sysArticleTag)) {
            articleTagMapper.insert(sysArticleTag);
        }
    }

    private boolean exists(SysArticleTag sysArticleTag) {
        LambdaQueryWrapper<SysArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysArticleTag::getArticleId, sysArticleTag.getArticleId());
        queryWrapper.eq(SysArticleTag::getTagId, sysArticleTag.getTagId());
        return articleTagMapper.selectList(queryWrapper).size() > 0;
    }

    @Override
    @Transactional
    public void deleteByArticleId(Long id) {
        LambdaQueryWrapper<SysArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysArticleTag::getArticleId, id);
        articleTagMapper.delete(queryWrapper);
    }

    @Override
    @Transactional
    public void deleteByTagsId(Long id) {
        LambdaQueryWrapper<SysArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysArticleTag::getTagId, id);
        articleTagMapper.delete(queryWrapper);
    }
}
