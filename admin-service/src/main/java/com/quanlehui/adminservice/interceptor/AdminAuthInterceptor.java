package com.quanlehui.adminservice.interceptor;

import com.quanlehui.adminservice.service.AdminAuthService;
import com.quanlehui.allserviceapi.admin.constant.Constants;
import com.quanlehui.allserviceapi.admin.domain.AdminUser;
import com.quanlehui.servicebase.base.util.JsonUtils;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:管理员用户权限拦截器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
public class AdminAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminAuthService adminAuthService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("start execute AdminAuthInterceptor preHandle... ");
        String login = "/login";
        String feign = "/feign";
        //后台获取验证码放行
        if (httpServletRequest.getServletPath().contains("imgcode")) {
            return true;
        }
        if (login.equals(httpServletRequest.getServletPath())) {
            return true;
        }
        if (httpServletRequest.getServletPath().contains(feign)) {
            return true;
        }

        String temp1 = "/contact/us/list";
        if (httpServletRequest.getServletPath().contains(temp1)) {
            return true;
        }

        String tem2 = "/wap/promotional/activities/info";
        if (httpServletRequest.getServletPath().contains(tem2)) {
            return true;
        }

        ExtendVO extendVO = adminAuthService.checkAuthority(httpServletRequest.getHeader("Authentication"),
                httpServletRequest.getServletPath());
        if (VOUtils.isOkExtendVO(extendVO)) {
            AdminUser adminUser = (AdminUser) extendVO.getData();
            httpServletRequest.setAttribute(Constants.ADMIN_USER_ID, adminUser.getId());
            httpServletRequest.setAttribute(Constants.ADMIN_USERNAME, adminUser.getUsername());
            return true;
        }
        JsonUtils.returnJson(httpServletResponse, extendVO);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
