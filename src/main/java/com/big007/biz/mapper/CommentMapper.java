package com.big007.biz.mapper;

import com.big007.biz.entity.SysComment;
import com.big007.common.utils.SplineChart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface CommentMapper extends BaseMapper<SysComment> {

    @Select("select date_format(create_time, '%Y-%m-%d') time, count(*) num from tb_comment group by date_format(create_time, '%Y-%m-%d')")
    List<SplineChart> chart();
}
