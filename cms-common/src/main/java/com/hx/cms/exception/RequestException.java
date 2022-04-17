package com.hx.cms.exception;

/**
 * @author: tywei
 * @create: 2022-04-11 5:38 下午
 **/
public class RequestException extends RuntimeException {

    public RequestException(String message) {
        super(message);
    }
    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
