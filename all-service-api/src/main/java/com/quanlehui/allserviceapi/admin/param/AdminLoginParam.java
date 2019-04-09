package com.quanlehui.allserviceapi.admin.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Desc    : 用户登录参数
 * @author  : yxy
 * @date    : 2018-02-23
 */
@Data
public class AdminLoginParam {

    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 用户密码
     */
    @NotNull
    private String password;

    /**
     * 图片验证码
     */
    private String imgCode;

    /**
     * 图片验证码id
     */
    private String imgCodeId;

}
