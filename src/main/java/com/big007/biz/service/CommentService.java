package com.big007.biz.service;

import com.big007.biz.entity.SysComment;
import com.big007.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface CommentService extends IService<SysComment> {

    /**
     * 根据ArticleId查询对应的评论列表
     */
    List<SysComment> findByArticleId(Long id);

    /**
     * 分页查询
     */
    IPage<SysComment> list(SysComment comment, QueryPage queryPage);

    void add(SysComment comment);

    void delete(Long id);

    List<Long[]> chart();
}
