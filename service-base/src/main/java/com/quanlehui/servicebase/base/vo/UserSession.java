package com.quanlehui.servicebase.base.vo;

import lombok.Data;

/**
 * 用户登录后的会话信息
 */
@Data
public class UserSession {

    private Long id;

    private String nickname;

    private Long loginTime;

    private String ip;

    /**
     * 客户端类型：0.pc;1.iso;2.android;3.wap
     */
    private int client = 0;

    /**
     * 网站首页地址
     */
    private String homeUrl;

}
