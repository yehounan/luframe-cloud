package com.quanlehui.servicebase.base.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Desc    : 缓存配置
 * Date    : 2018-01-01
 *
 * @author : yxy
 */
@Configuration
@EnableCaching
public class CacheConfig {
    /**
     * 最大缓存条数
     */
    public static final int DEFAULT_MAXSIZE = 10000;
    /**
     * //过期时间
     */
    public static final int DEFAULT_TTL = 3600;

    /**
     * 配置缓存管理器
     */
    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(DEFAULT_TTL, TimeUnit.SECONDS).maximumSize(DEFAULT_MAXSIZE));
        return guavaCacheManager;
    }

}
