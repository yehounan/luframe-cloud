package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminLoginService;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.param.AdminLoginParam;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.cache.RedisCache;
import com.quanlehui.servicebase.base.constant.RedisKeyConstants;
import com.quanlehui.servicebase.base.util.TimeUtils;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 后台登录控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
public class AdminLoginController  {

    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    RedisCache redisCache;

    /**
     * 后台管理登陆
     * @param adminLoginParam
     * @param httpServletRequest
     * @return
     */
    @RecordLog
    @PostMapping(URIConstants.LOGIN)
    public ExtendVO login(@Validated @RequestBody AdminLoginParam adminLoginParam, HttpServletRequest httpServletRequest) {
        return adminLoginService.getTokenByAdminUserPassword(adminLoginParam,httpServletRequest);
    }

    /**
     * 后台管理操作日志查询
     * @param adminOperateLogQueryParam
     * @return
     */
    @PostMapping(URIConstants.OPERATELOG_QUERY)
    public ExtendVO loginLogQuery(@RequestBody AdminOperateLogQueryParam adminOperateLogQueryParam) {
        if(adminOperateLogQueryParam.getStartPoint() != null){
            adminOperateLogQueryParam.setStartPoint(TimeUtils.getStartTime(adminOperateLogQueryParam.getStartPoint().getTime()));
        }
        if(adminOperateLogQueryParam.getEndPoint() != null){
            adminOperateLogQueryParam.setEndPoint(TimeUtils.getEndTime(adminOperateLogQueryParam.getEndPoint().getTime()));
        }
        String cacheKey = RedisKeyConstants.ADMIN_OPERATELOG_QUERY+
                (adminOperateLogQueryParam.getPageNum()==null?1:adminOperateLogQueryParam.getPageNum())+"_"+
                (adminOperateLogQueryParam.getPageSize()==null?20:adminOperateLogQueryParam.getPageSize())+"_"+
                (adminOperateLogQueryParam.getUsername()==null?"null":adminOperateLogQueryParam.getUsername().replaceAll(" ","_"))+"_"+
                (adminOperateLogQueryParam.getIp()==null?"null":adminOperateLogQueryParam.getIp().replaceAll(" ","_"))+"_"+
                (adminOperateLogQueryParam.getStartPoint()==null?"null":adminOperateLogQueryParam.getStartPoint().getTime())+"_"+
                (adminOperateLogQueryParam.getEndPoint()==null?"null":adminOperateLogQueryParam.getEndPoint().getTime());
        return redisCache.getCacheValue(cacheKey, 2 * 60, new RedisCache.RedisCacheValueNotFound<ExtendVO>() {
            @Override
            public ExtendVO getValue() {
                return adminLoginService.operateLogQuery(adminOperateLogQueryParam);
            }
        });
    }

    /**
     * 获取管理员自身信息
     * @param httpServletRequest
     * @return
     */
    @GetMapping(URIConstants.SELF_INFO)
    public ExtendVO getSelfInfo(HttpServletRequest httpServletRequest) {
        return adminLoginService.getSelfInfo(httpServletRequest);
    }

}
