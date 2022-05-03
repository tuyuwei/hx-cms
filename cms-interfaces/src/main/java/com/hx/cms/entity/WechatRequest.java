package com.hx.cms.entity;


import lombok.Data;

@Data
public class WechatRequest {
    private String code;
    private String avatarUrl;
    private String nickName;
    private String openId;
}
