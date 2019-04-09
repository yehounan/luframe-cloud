package com.quanlehui.adminservice.service;



import com.quanlehui.allserviceapi.admin.param.AdminLoginParam;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.vo.ExtendVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminLoginService {

    /**
     * 检查管理员用户密码：
     * 正确：生成token
     * 错误：给出错误信息
     * @param adminLoginParam
     * @param httpServletRequest
     * @return
     */
    ExtendVO getTokenByAdminUserPassword(AdminLoginParam adminLoginParam, HttpServletRequest httpServletRequest);

    /**
     * 后台管理操作日志查询
     * @param adminOperateLogQueryParam
     * @return
     */
    ExtendVO operateLogQuery(AdminOperateLogQueryParam adminOperateLogQueryParam);

    /**
     * 查询当前登录管理员用户信息
     * @param httpServletRequest
     * @return
     */
    ExtendVO getSelfInfo(HttpServletRequest httpServletRequest);
}
