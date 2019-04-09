package com.quanlehui.allserviceapi.admin.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Desc    :
 * @author  : yxy
 * @date    : 2018-02-11
 */
@Data
public class AdminUserDTO {

    protected Long id;

    protected Date createTime;

    private String username;

    private String password;

    private Byte state;

    private String realname;

    private String phone;

    private String email;

    private List<Map> role;

    private String deptName;

    private Integer deptId;

    private Boolean isAdmin;

    private Integer seeMemberAll;

}
