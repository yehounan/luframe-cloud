package com.quanlehui.servicebase.base.aop;


import com.quanlehui.servicebase.base.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc   : 接口耗时计算的切面
 * Author : yxy
 * Date   : 2017-12-20
 */
@Slf4j
@Aspect
@Component
public class TimeCostAspect {
    private static Logger logger = LoggerFactory.getLogger(TimeCostAspect.class);
    private static final String POINT = "execution (* com.huanya..*.controller..*.*(..))";

    @Pointcut(POINT)
    public void performance() {
    }

    @Around("performance()")
    public Object watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        obj = joinPoint.proceed(args);
        if (!(obj instanceof BaseVO)) {
            return obj;
        }
        long endTime = System.currentTimeMillis();
        BaseVO baseVO = (BaseVO) obj;
        long cost = endTime - startTime;
        baseVO.setCost(cost);
        if(cost >= 100L) {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            log.warn("Request:{} cost:{}ms is too long!", request.getRequestURI(), cost);
        }
        return baseVO;
    }
}
