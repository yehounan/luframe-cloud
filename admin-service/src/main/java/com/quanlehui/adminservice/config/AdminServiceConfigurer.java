package com.quanlehui.adminservice.config;


import com.quanlehui.adminservice.interceptor.AdminAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 后台管理系统配置类
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Configuration
public class AdminServiceConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public AdminAuthInterceptor getAdminAuthInterceptor() {
        return new AdminAuthInterceptor();
    }

    /**
     * 添加权限验证拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAdminAuthInterceptor());
        super.addInterceptors(registry);
    }

}
