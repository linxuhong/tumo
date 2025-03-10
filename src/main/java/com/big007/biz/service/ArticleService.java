package com.big007.biz.service;

import com.big007.biz.entity.SysArticle;
import com.big007.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface ArticleService extends IService<SysArticle> {

    /**
     * 根据CategoryId查询文章数据
     *
     * @param id Category Id
     */
    List<SysArticle> findByCategory(Long id);

    /**
     * 根据TagId查询文章数据
     *
     * @param id Tag id
     */
    List<SysArticle> findByTag(Long id);

    IPage<SysArticle> list(SysArticle sysArticle, QueryPage queryPage);

    SysArticle findById(Long id);

    void update(SysArticle sysArticle);

    void delete(Long id);

    void add(SysArticle sysArticle);
}
