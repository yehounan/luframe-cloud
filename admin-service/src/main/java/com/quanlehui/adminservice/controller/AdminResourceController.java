package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminResourceService;
import com.quanlehui.adminservice.util.AdminLoginUserUtils;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.param.AdminResourceInsertParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 后台资源控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@RestController
public class AdminResourceController {

    @Autowired
    AdminResourceService adminResourceService;

    @GetMapping(URIConstants.RESOURCE_LIST)
    public ExtendVO getMenuResourceList(@RequestParam(value = "roleId", required = false) Long roleId) {
        return adminResourceService.getResourceList(roleId);
    }

    @GetMapping(URIConstants.MENU_LIST)
    public ExtendVO getMenuList(HttpServletRequest httpServletRequest) {
        Long userId = AdminLoginUserUtils.getAdminUserId(httpServletRequest);
        return adminResourceService.getMenuList(userId);
    }

    @RecordLog
    @PostMapping(URIConstants.RESOURCE_INSERT)
    public BaseVO resourceInsert(@Validated @RequestBody AdminResourceInsertParam adminResourceInsertParam) {
        return adminResourceService.insertResource(adminResourceInsertParam);
    }

}
