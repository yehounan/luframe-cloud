package com.quanlehui.allserviceapi.admin.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Desc    : 用户新增参数
 * @author  : yxy
 * @date    : 2018-02-11
 */
@Data
public class AdminUserInsertParam {

    @NotEmpty(message = "username不能为空")
    private String username;

    @NotEmpty(message = "password不能为空")
    private String password;

    private Byte state;

    private String realname;

    @NotEmpty(message = "phone不能为空")
    private String phone;

    private String email;

    /**
     * 角色id
     */
    @NotEmpty(message = "roleId不能为空")
    private String roleId;

    /**
     * 部门id
     */
    @NotEmpty(message = "deptId不能为空")
    private Integer deptId;

    /**
     * 是否可查看会员完整信息 0不可以; 1可以
     */
    private Integer seeMemberAll;
}
