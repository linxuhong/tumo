package com.big007.biz.mapper;

import com.big007.biz.entity.SysArticleTag;
import com.big007.biz.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface ArticleTagMapper extends BaseMapper<SysArticleTag> {

    List<SysTag> findByArticleId(long articleId);
}
