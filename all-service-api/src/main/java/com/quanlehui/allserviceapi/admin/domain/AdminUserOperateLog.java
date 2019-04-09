package com.quanlehui.allserviceapi.admin.domain;


import com.quanlehui.servicebase.base.domain.BaseDomain;
import lombok.Data;

/**
 * Desc    : 用户操作日志
 * @author  : yxy
 * @date    : 2018-05-21
 */
@Data
public class AdminUserOperateLog extends BaseDomain {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 执行方法所在类
     */
    private String className;

    /**
     * 执行方法名
     */
    private String methodName;

    /**
     * 执行方法入参
     */
    private String params;

    /**
     * 执行方法返回结果
     */
    private String result;
}
