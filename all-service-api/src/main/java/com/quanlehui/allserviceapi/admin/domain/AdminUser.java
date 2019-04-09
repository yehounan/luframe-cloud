package com.quanlehui.allserviceapi.admin.domain;


import com.quanlehui.servicebase.base.domain.BaseDomain;
import lombok.Data;

/**
 * Description 用户表表数据库对象
 *
 * @author yxy
 * @date 2018/12/12
 */
@Data
public class AdminUser extends BaseDomain {
    private String username;

    private String password;

    private Byte state;

    private String realname;

    private String phone;

    private String email;

    private Integer  deptId;

    private Integer seeMemberAll;

    @Override
    public String toString() {
        return "AdminUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}