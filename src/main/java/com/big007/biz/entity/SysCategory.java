package com.big007.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@Data
@TableName("tb_category")
public class SysCategory implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
}
