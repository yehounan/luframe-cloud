package com.quanlehui.adminservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.quanlehui.adminservice.mapper.AdminUserOperateLogMapper;
import com.quanlehui.adminservice.service.AdminUserOperateLogService;
import com.quanlehui.allserviceapi.admin.dto.AdminUserOperateLogDTO;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作日志service
 * @author yezi
 * @date 2018/9/28 10:08
 */
@Service
public class AdminUserOperateLogServiceImpl implements AdminUserOperateLogService {

    @Autowired
    AdminUserOperateLogMapper adminUserOperateLogMapper;

    @Override
    public ExtendVO getAdminUserOperateLogList(AdminOperateLogQueryParam adminOperateLogQueryParam) {
        PageHelper.startPage(adminOperateLogQueryParam.getPageNum(), adminOperateLogQueryParam.getPageSize());
        List<AdminUserOperateLogDTO> list = adminUserOperateLogMapper.getAdminUserOperateLogList(adminOperateLogQueryParam);
        PageInfo<AdminUserOperateLogDTO> pageInfo = new PageInfo<>(list);
        return VOUtils.returnExtendVOFillPageInfo(pageInfo);
    }
}
