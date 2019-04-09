package com.quanlehui.adminservice.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @Description: 需要记录日志注解
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RecordLog {

}
