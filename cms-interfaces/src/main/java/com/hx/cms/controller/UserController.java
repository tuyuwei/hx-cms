package com.hx.cms.controller;

import com.hx.cms.entity.WechatResponse;
import com.hx.cms.service.UserLoginService;
import com.hx.protocol.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(tags = {"用户模块"})
@RestController
public class UserController {

    @Resource
    private UserLoginService userLoginService;

    @ApiOperation(value = "登陆")
    @GetMapping(value = "/login")
    public Result<WechatResponse> login(String code) {
        return Result.ofSuccess(userLoginService.login(code));
    }

}
