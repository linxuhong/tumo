package com.big007.common.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * HighChart.js Spline图表数据封装
 *
 * @author big007@foxmail.com
 * @date 2020/6/28
 */
@Data
@Accessors(chain = true)
public class SplineChart implements Serializable {

    private String time;

    private Long num;
}
