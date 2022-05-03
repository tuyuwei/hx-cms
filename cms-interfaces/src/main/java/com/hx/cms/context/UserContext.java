package com.hx.cms.context;

import com.hx.cms.entity.WechatResponse;
import lombok.Data;

@Data
public class UserContext {

    private String openId;

    private String sessionKey;

    public static UserContext build(WechatResponse response) {
        UserContext context = new UserContext();
        context.setOpenId(response.getOpenid());
        context.setSessionKey(response.getSession_key());
        return context;
    }
}
