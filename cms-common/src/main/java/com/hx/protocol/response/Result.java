package com.hx.protocol.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: tywei
 * @create: 2022-04-11 2:25 下午
 **/
@Data
@ApiModel("统一 Response 返回值")
public class Result<T> {
    public static final Long SUCCESS_CODE = 200L;
    public static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            name = "业务域或应用标识",
            notes = "仅当产生错误时会赋值该字段"
    )
    private String domain;
    @ApiModelProperty(
            name = "结果码",
            notes = "正确响应时该值为 Result#SUCCESS_CODE，错误响应时为错误代码"
    )
    private long code;
    @ApiModelProperty(
            name = "人工可读的消息",
            notes = "正确响应时该值为 Result#DEFAULT_SUCCESS_MESSAGE，错误响应时为错误信息"
    )
    private String msg;
    @ApiModelProperty(
            name = "响应体",
            notes = "正确响应时该值会被使用"
    )
    private T data;
    @ApiModelProperty("错误信息")
    private List<Result.Error> errors;

    public Result(T data) {
        this.setData(data);
        this.setCode(SUCCESS_CODE);
        this.setMsg("success");
    }

    private Result(int code, String msg) {
        this.setCode((long) code);
        this.setMsg(msg);
    }

    public Result() {
        this.setCode(SUCCESS_CODE);
        this.setMsg("success");
    }

    public static <T> Result<T> ofSuccess(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> ofError(int code, String msg) {
        return new Result<>(code, msg);
    }

    public static boolean isSuccess(Result result) {
        return !Objects.isNull(result) && SUCCESS_CODE.equals(result.getCode());
    }

    public void addError(String name, String message) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(new Error(name, message));
    }

    @AllArgsConstructor
    @Data
    public static class Error {
        private String name;
        private String message;
    }
}
