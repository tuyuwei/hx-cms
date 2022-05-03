package com.hx.cms.entity;

import com.hx.cms.exception.OperateException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Data
public class WechatResponse {
    /**
     * 用户的唯一标识
     */
    private String openid;
    /**
     * 会话秘钥（具有时效性，用户登录的临时通行证）
     * 登录后前端的每次接口请求都需带上session_key
     */
    private String session_key;
    /**
     * 错误码
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    public void verify() {
        if (StringUtils.isBlank(openid) || StringUtils.isBlank(session_key)) {
            log.warn("用户登陆失败. {}", this);
            throw new OperateException("用户登陆失败.");
        }
    }
}
