package com.big007.biz.mapper;

import com.big007.biz.entity.SysArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface ArticleMapper extends BaseMapper<SysArticle> {

    List<SysArticle> findByCategory(Long id);

    List<SysArticle> findByTag(Long id);
}
