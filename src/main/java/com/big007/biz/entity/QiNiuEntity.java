package com.big007.biz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QiNiuEntity implements Serializable {

    private String key; //对象KEY
    private String name; //对象名称
    private String type; //对象类型
    private long size; //对象大小
    private String url; //对象链接
}
