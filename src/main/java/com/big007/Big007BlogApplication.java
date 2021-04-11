package com.big007;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动器类
 *
 * @author
 * @date 2020/6/27
 */
@SpringBootApplication
@MapperScan("com.big007.biz.mapper")
public class Big007BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Big007BlogApplication.class, args);
    }
}
