package com.big007.biz.mapper;

import com.big007.biz.entity.SysCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface CategoryMapper extends BaseMapper<SysCategory> {

    List<SysCategory> findCategoryByArticleId(long id);
}
