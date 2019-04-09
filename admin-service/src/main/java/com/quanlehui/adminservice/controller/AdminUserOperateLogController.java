package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.service.AdminUserOperateLogService;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台用户操作日志控制器
 * @author yezi
 * @date 2018/9/28 10:04
 */
@RestController
public class AdminUserOperateLogController {

    @Autowired
    AdminUserOperateLogService adminUserOperateLogService;

    /**
     * 查询用户操作日志列表
     * @param adminOperateLogQueryParam
     * @return
     */
    @PostMapping(URIConstants.OPERATE_LOG_LIST)
    public ExtendVO adminOperateLogList(@RequestBody AdminOperateLogQueryParam adminOperateLogQueryParam) {
        return adminUserOperateLogService.getAdminUserOperateLogList(adminOperateLogQueryParam);
    }
}
