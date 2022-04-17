package com.hx.cms.exception;

/**
 * @author: tywei
 * @create: 2022-04-11 5:38 下午
 **/
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
