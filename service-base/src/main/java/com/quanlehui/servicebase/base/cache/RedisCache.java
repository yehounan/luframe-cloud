package com.quanlehui.servicebase.base.cache;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Desc    : Redis缓存包装类
 * Date    : 2018-01-01
 *
 * @author : yxy
 */
@Component
public class RedisCache {
    private static final long DEFAULT_CACHE_EXPIRE = 60L;
    private static final TimeUnit CACHE_TIME_UNIT = TimeUnit.SECONDS;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    ValueOperations<String, Object> valueOperations;

    public interface RedisCacheValueNotFound<T> {
        T getValue();
    }

    public <T> void setCacheValue(String cacheKey, T cacheValue, long expire) {
        if(StringUtils.isBlank(cacheKey) || cacheValue == null){
            return;
        }
        valueOperations.set(cacheKey,cacheValue,expire, CACHE_TIME_UNIT);
    }

    public  <T> T getCacheValue(String cacheKey, RedisCacheValueNotFound<T> redisCacheNotFound){
        return getCacheValue(cacheKey,DEFAULT_CACHE_EXPIRE,redisCacheNotFound);
    }

    public  <T> T getCacheValue(String cacheKey, long expire, RedisCacheValueNotFound<T> redisCacheNotFound){
        Object value = valueOperations.get(cacheKey);
        if(value != null){
            return (T) value;
        }
        T tValue = redisCacheNotFound.getValue();
        if(tValue != null){
            setCacheValue(cacheKey,tValue,expire);
            return tValue;
        }
        return null;
    }

    public void delete(String cacheKey){
        redisTemplate.delete(cacheKey);
    }

}
