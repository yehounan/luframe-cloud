package com.quanlehui.allserviceapi.admin.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Desc    : 用户更新参数
 * @author  : yxy
 * @date    : 2018-02-11
 */
@Data
public class AdminUserUpdateParam {

    private Long id;

    @Length(max = 33,min = 2,message = "你输入的用户名太长了，请重新输入")
    private String username;

    private String password;

    private Byte state;

    private String realname;

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
    private Integer deptId;

    /**
     * 是否可查看会员完整信息 0不可以; 1可以
     */
    private Integer seeMemberAll;
}
