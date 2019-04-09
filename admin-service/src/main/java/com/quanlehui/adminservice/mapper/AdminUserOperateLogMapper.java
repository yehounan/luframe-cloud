package com.quanlehui.adminservice.mapper;


import com.quanlehui.allserviceapi.admin.domain.AdminUserOperateLog;
import com.quanlehui.allserviceapi.admin.dto.AdminUserOperateLogDTO;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Repository
public interface AdminUserOperateLogMapper extends BaseMapper<AdminUserOperateLog> {

    /**
     * 获取用户管理员操作日志列表
     * @param adminOperateLogQueryParam
     * @return
     */
    List<AdminUserOperateLogDTO> getAdminUserOperateLogList(AdminOperateLogQueryParam adminOperateLogQueryParam);

}
