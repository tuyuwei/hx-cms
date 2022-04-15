package com.hx.cms.exception;

/**
 * @author: tywei
 * @create: 2022-04-11 5:38 下午
 **/
public class OperateException extends RuntimeException {

    public OperateException(String message, Throwable cause) {
        super(message, cause);
    }
}
