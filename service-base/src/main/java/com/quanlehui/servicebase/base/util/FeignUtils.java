package com.quanlehui.servicebase.base.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Desc    : 针对Spring Cloud Feign的封装工具类
 * Date    : 2017-12-26
 * @author : yxy
 */
public class FeignUtils {
    private static Logger logger = LoggerFactory.getLogger(FeignUtils.class);

    /**
     * 将Map格式的ExtendVO的data数据转换转化为其真实类型
     * @param extendVO
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convertToRealTypeDataFromMap(ExtendVO extendVO, Class<T> clazz){
        T t =null;
        if (extendVO != null){
            Object o = extendVO.getData();
            if(o != null && o instanceof Map){
                t = convertToRealTypeDataFromMap((Map) o,clazz);
            }
        }
        return t;
    }


    /**
     * 将Map格式的数据转换转化为其真实类型
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convertToRealTypeDataFromMap(Map map, Class<T> clazz){
        T t =null;
        if(map != null){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String json;
            try {
                json = objectMapper.writeValueAsString(map);
                t = objectMapper.readValue(json, clazz);
                /*logger.info("execute convert success.");*/
            } catch (Exception e) {
                logger.error("convert error!");
            }
        }
        return t;
    }

    /**
     * 将Map格式的数据转换转化为其真实类型
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convertToRealTypeDataFromMap2(Map map, Class<T> clazz){
        T t =null;
        if(map != null){
            try {
                t = clazz.newInstance();
            } catch (Exception e) {
                logger.error("",e);
                return t;
            }
            BeanMap beanMap = BeanMap.create(t);
            beanMap.putAll(map);
        }
        return t;
    }

    /**
     * 将Map元素的List转换转化为其真实类型List
     * @param list
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convertToRealTypeDataFromListMap(List<Map> list,Class<T> clazz){
        List<T> resultList = new ArrayList<>();
        for(Map m :list){
            T t = convertToRealTypeDataFromMap(m,clazz);
            resultList.add(t);
        }
        return resultList;
    }

}
