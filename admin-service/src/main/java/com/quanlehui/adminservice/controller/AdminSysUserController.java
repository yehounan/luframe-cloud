package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminUserService;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.param.AdminUserInsertParam;
import com.quanlehui.allserviceapi.admin.param.AdminUserUpdateParam;
import com.quanlehui.servicebase.base.param.PageParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 后台用户控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
public class AdminSysUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping(URIConstants.ADMINUSER_LIST)
    public ExtendVO adminUserList(@RequestBody PageParam pageParam) {
        return adminUserService.getAdminUserList(pageParam);
    }

    @RecordLog
    @PostMapping(URIConstants.ADMINUSER_INSERT)
    public BaseVO adminUserInsert(@RequestBody AdminUserInsertParam adminUserInsertParam) {
        return adminUserService.adminUserInsert(adminUserInsertParam);
    }

    @RecordLog
    @PostMapping(URIConstants.ADMINUSER_UPDATE)
    public BaseVO adminUserUpdate(@Validated @RequestBody AdminUserUpdateParam adminUserUpdateParam) {
        return adminUserService.adminUserUpdate(adminUserUpdateParam);
    }

    @RecordLog
    @GetMapping(URIConstants.ADMINUSER_DELETE)
    public BaseVO adminUserDelete(@RequestParam("id") Long id) {
        return adminUserService.adminUserDelete(id);
    }

    @RecordLog
    @GetMapping(URIConstants.ADMINUSER_RESET_PASSWORD)
    public BaseVO adminUserResetPassword(@RequestParam("id") Long id,@RequestParam("pwd") String pwd) {
        return adminUserService.adminUserResetPassword(id,pwd);
    }






}
