package com.big007.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 全局异常处理
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public class GlobalException extends RuntimeException {

    @Getter
    @Setter
    private String msg;

    public GlobalException(String message) {
        super(message);
        this.msg = message;
    }
}
