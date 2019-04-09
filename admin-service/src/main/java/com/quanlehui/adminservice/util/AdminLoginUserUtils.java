package com.quanlehui.adminservice.util;


import com.quanlehui.allserviceapi.admin.constant.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 获取管理员用户登录信息
 * @author  Administrator
 * @date   2018/2/2
 */
public class AdminLoginUserUtils {

    /**
     * 获取管理员ID
     * @param request
     * @return
     */
    public  static Long getAdminUserId(HttpServletRequest request) {
          Long userId= (Long) request.getAttribute(Constants.ADMIN_USER_ID);
          return userId;

    }

    /**
     * 获取管理员用户名
     * @param request
     * @return
     */
    public static String getAdminUsername(HttpServletRequest request) {
        String username= (String) request.getAttribute(Constants.ADMIN_USERNAME);
        return username;
    }

}
