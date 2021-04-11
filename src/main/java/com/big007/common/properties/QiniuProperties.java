package com.big007.common.properties;

import lombok.Data;

/**
 * 七牛云配置参数
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@Data
public class QiniuProperties {

    /**
     * AccessKey
     */
    private String ak;

    /**
     * SecretKey
     */
    private String sk;

    /**
     * BucketName
     */
    private String bn;

    /**
     * 外链
     */
    private String url;
}
