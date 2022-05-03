package com.hx.cms.service;

import com.hx.cms.entity.WechatRequest;
import com.hx.protocol.response.Result;

public interface UserLoginService {

    /**
     * 微信小程序登陆
     *
     * @param request
     * @return
     */
    Result<Void> login(WechatRequest request);

}
