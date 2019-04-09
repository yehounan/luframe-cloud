package com.quanlehui.adminservice.service;


import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.vo.ExtendVO;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminUserOperateLogService {

    /**
     * 查询操作日志列表（分页）
     * @param adminOperateLogQueryParam
     * @return
     */
    ExtendVO getAdminUserOperateLogList(AdminOperateLogQueryParam adminOperateLogQueryParam);
}
