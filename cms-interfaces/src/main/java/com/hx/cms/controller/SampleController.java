package com.hx.cms.controller;

import com.google.common.collect.Lists;
import com.hx.protocol.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例
 *
 * @author: tywei
 * @create: 2022-04-10 3:02 下午
 **/
@Slf4j
@RequestMapping(value = "/sample", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(tags = {"测试"})
@RestController
public class SampleController {

    @ApiOperation(value = "根据任务编号进行上架")
    @GetMapping(value = "/test")
    public Result<String> test() {
        log.info("test 123");
        return Result.ofSuccess("OK");
    }

}