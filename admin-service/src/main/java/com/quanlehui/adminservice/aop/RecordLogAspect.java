package com.quanlehui.adminservice.aop;

import com.alibaba.fastjson.JSONObject;

import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.mapper.AdminUserOperateLogMapper;
import com.quanlehui.allserviceapi.admin.constant.Constants;
import com.quanlehui.allserviceapi.admin.domain.AdminUserOperateLog;
import com.quanlehui.servicebase.base.util.IpUtil;
import com.quanlehui.servicebase.base.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * @Description: 日志切面
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@Aspect
@Component
public class RecordLogAspect {

    private static final String POINT = "execution (* com.huanya..*.controller..*.*(..))";

    @Autowired
    private AdminUserOperateLogMapper adminUserOperateLogMapper;

    @Pointcut(POINT)
    public void performance() {
    }

    @AfterReturning(value = "performance() && @annotation(recordLog) ", argNames = "joinPoint,recordLog,result",
            returning = "result")
    public void watchPerformance(JoinPoint joinPoint, RecordLog recordLog, Object result) throws Throwable {
        //获取方法入参
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        String requestURI = httpServletRequest.getRequestURI();
        //如果是feign调用，则不做记录
        String feignMark = "/feign";
        if (requestURI.contains(feignMark)) {
            return;
        }
        String servletPath = httpServletRequest.getServletPath();
        String requestMethod = httpServletRequest.getMethod();
        Long userId = (Long) httpServletRequest.getAttribute(Constants.ADMIN_USER_ID);

        String ip = IpUtil.getIpAddr(httpServletRequest);

        String params = "";
        if (args != null && args.size() > 0) {
            //1.处理request中入参，但获取不到注解的bean
            Enumeration enumeration = httpServletRequest.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String name = (String) enumeration.nextElement();
                String value = httpServletRequest.getParameter(name);
                params += name + "=" + value + ",";
            }
            params += ";";
            //2.处理注解的bean
            for (int i = 0; i < args.size(); i++) {
                params += JSONObject.toJSONString(args.get(i) + ";");
            }
        }
        log.info("ip={}", ip);
        BaseVO baseVO0 = (BaseVO) result;
        BaseVO baseVO = new BaseVO();
        baseVO.setCode(baseVO0.getCode());
        baseVO.setMessage(baseVO0.getMessage());
        baseVO.setCost(baseVO0.getCost());
        AdminUserOperateLog adminUserOperateLog = new AdminUserOperateLog();
        adminUserOperateLog.setUserId(userId);
        adminUserOperateLog.setLoginIp(ip);
        adminUserOperateLog.setRequestUri(requestURI);
        adminUserOperateLog.setRequestMethod(requestMethod);
        adminUserOperateLog.setClassName(className);
        adminUserOperateLog.setMethodName(methodName);
        adminUserOperateLog.setParams(params);
        adminUserOperateLog.setResult(baseVO.toString());
        adminUserOperateLog.setCreateTime(new Date());
        adminUserOperateLogMapper.insert(adminUserOperateLog);
    }
}
