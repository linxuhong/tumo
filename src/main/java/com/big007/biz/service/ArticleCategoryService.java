package com.big007.biz.service;

import com.big007.biz.entity.SysArticleCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface ArticleCategoryService extends IService<SysArticleCategory> {

    /**
     * 新增
     *
     * @param sysArticleCategory
     */
    void add(SysArticleCategory sysArticleCategory);

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    void deleteByArticleId(Long id);

    /**
     * 根据分类ID删除
     *
     * @param id
     */
    void deleteByCategoryId(Long id);
}
