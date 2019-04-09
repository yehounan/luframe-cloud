package com.quanlehui.servicebase.base.util;



import com.quanlehui.servicebase.base.constant.Constants;
import com.quanlehui.servicebase.base.vo.UserSession;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取登录信息
 * Created by Administrator on 2018/2/2.
 */
public class LoginUserInfoUtils {

    public static UserSession getUserSession(HttpServletRequest request) {
        return (UserSession) request.getAttribute(Constants.USER_SESSION);
    }

    public static Long getUserId(HttpServletRequest request) {
        UserSession user = (UserSession) request.getAttribute(Constants.USER_SESSION);
        return user.getId();
    }


    public static String getUserNickName(HttpServletRequest request) {
        UserSession user = (UserSession) request.getAttribute(Constants.USER_SESSION);
        return user.getNickname();
    }

}
