package com.hx.cms.service;

import com.hx.cms.entity.WechatResponse;

public interface UserLoginService {

    /**
     * 微信小程序登陆
     *
     * @param code
     * @return
     */
    WechatResponse login(String code);

}
