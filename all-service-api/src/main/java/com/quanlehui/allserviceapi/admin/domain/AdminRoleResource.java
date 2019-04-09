package com.quanlehui.allserviceapi.admin.domain;


import com.quanlehui.servicebase.base.domain.BaseDomain;

/**
 * Description 角色资源表数据库对象
 *
 * @author yxy
 * @date 2018/12/12
 */
public class AdminRoleResource extends BaseDomain {
    private Long roleId;

    private Long resourceId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}