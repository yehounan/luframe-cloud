package com.quanlehui.allserviceapi.admin.domain;


import com.quanlehui.servicebase.base.domain.BaseDomain;

/**
 * Description 用户角色表数据库对象
 *
 * @author yxy
 * @date 2018/12/12
 */
public class AdminUserRole extends BaseDomain {
    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}