package com.hx.cms.service.impl;

import com.hx.cms.config.WechatAppConfig;
import com.hx.cms.context.UserContext;
import com.hx.cms.context.UserContextHolder;
import com.hx.cms.entity.WechatResponse;
import com.hx.cms.exception.OperateException;
import com.hx.cms.service.UserLoginService;
import com.hx.utils.HttpClientUtils;
import com.hx.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private WechatAppConfig wechatAppConfig;

    @Override
    public WechatResponse login(String code) {
        log.info("wechat login code:{} config:{}", code, wechatAppConfig);
        String url = wechatAppConfig.buildUri() + "&js_code=" + code + "&grant_type=authorization_code";
        WechatResponse response = HttpClientUtils.get(url, WechatResponse.class, null);
        if (Objects.isNull(response)) {
            throw new OperateException("登陆失败. body is null");
        }
        response.verify();
        //注册上下文
        UserContextHolder.buildContext(UserContext.build(response));
        return response;
    }

    public void logout() {
        UserContextHolder.remove();
    }

    public static void main(String[] args) {
        WechatAppConfig config = new WechatAppConfig();

        String str = JsonUtils.encode(null);
        System.out.println(str);
    }
}
