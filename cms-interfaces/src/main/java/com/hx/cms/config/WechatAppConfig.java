package com.hx.cms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wechat.app")
@Data
public class WechatAppConfig {

    //在开发者平台中获取APPID和appSecret
    private String url;

    private String id;

    private String secret;

    public String buildUri() {
        return url + "?appid=" + id + "&secret=" + secret;
    }
}
