package com.big007.common.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 密码加密方法测试
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5UtilTest {

    @Autowired
    private Md5Util md5Util;

    @Test
    public void encryptPassword() {
        /**
         * password（明文）: big007@foxmail.com
         * password（密文）: c82a27d50dd5f3a536c85211cc7f2346
         */
        String encryptPassword = md5Util.encryptPassword("big007@foxmail.com");
        System.out.println(encryptPassword);
    }
}
