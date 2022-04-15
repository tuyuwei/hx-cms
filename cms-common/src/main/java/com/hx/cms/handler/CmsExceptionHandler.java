package com.hx.cms.handler;

import com.hx.cms.exception.OperateException;
import com.hx.cms.exception.RequestException;
import com.hx.cms.exception.SystemException;
import com.hx.protocol.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author: tywei
 * @create: 2022-04-11 5:33 下午
 **/
@ControllerAdvice
@Order(value = -1000)
@Slf4j
public class CmsExceptionHandler {

    @ExceptionHandler(value = {
            RequestException.class,
            OperateException.class,
            BindException.class,
            MethodArgumentNotValidException.class,
    })
    @ResponseBody
    public Result<Void> handleOperateException(Exception ex) {
        log.info("操作失败.", ex);
        Result<Void> result = new Result<>();
        result.setMsg(ex.getMessage());
        result.setCode(-1);
        return result;
    }

    @ExceptionHandler(value = {
            SystemException.class,
            Exception.class,
    })
    @ResponseBody
    public Result<Void> handleException(Exception ex) {
        log.error("system error.", ex);
        String msg = "系统错误." + ex.getMessage();
        Result<Void> result = new Result<>();
        result.setMsg(msg);
        result.setCode(-1);
        return result;
    }
}
