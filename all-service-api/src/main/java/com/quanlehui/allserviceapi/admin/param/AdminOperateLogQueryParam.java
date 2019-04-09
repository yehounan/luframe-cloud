package com.quanlehui.allserviceapi.admin.param;


import com.quanlehui.servicebase.base.param.TimeScopeNotRequiredParam;
import lombok.Data;

/**
 * Desc    : 管理员用户登录日志查询接口
 * @author  : yxy
 * @date    : 2018-05-17
 */
@Data
public class AdminOperateLogQueryParam extends TimeScopeNotRequiredParam {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * ip地址
     */
    private String ip;

}
