package com.quanlehui.allserviceapi.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * Desc    : 管理员用户token数据传输对象
 * @date    : 2018-01-13
 *
 * @author : yxy
 */
@Data
public class AdminUserMyTokenDTO {

    private String myToken;

    private String username;

    private Date createTime;

    private String loginIp;

}
