package com.big007.common.utils;

import com.big007.common.properties.ShiroProperties;
import com.big007.common.properties.TumoProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Shiro 加密工具
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@Component
public class Md5Util {

    @Autowired
    private TumoProperties properties;

    /**
     * 算法名称
     */
    private static final String ALGORITH_NAME = "MD5";

    /**
     * 迭代次数
     */
    private static final int HASH_ITERATIONS = 2;

    /**
     * Shiro 加密
     *
     * @param password 明文密码
     * @return 加密后的密码
     * @value shiro.getCipherKey() 加密混用的盐值
     */
    public String encryptPassword(String password) {
        ShiroProperties shiro = properties.getShiro();
        if (password == null) {
            return null;
        }
        return new SimpleHash(
                ALGORITH_NAME,
                StringUtils.lowerCase(StringUtils.lowerCase(password)),
                shiro.getCipherKey(),
                HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        String password = "123456";
      String enc=  new SimpleHash(
                ALGORITH_NAME,
                StringUtils.lowerCase(StringUtils.lowerCase(password)),
                "big007@foxmail.com",
                HASH_ITERATIONS).toHex();
        System.out.println(enc);
    }
}
