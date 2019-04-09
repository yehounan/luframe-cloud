package com.quanlehui.servicebase.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Desc   : WEB模块JSON工具类
 * Author : yxy
 * Date   : 2017-12-20
 */
public class JsonUtils {
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static void returnJson(HttpServletResponse response, Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        String objJson = null;
        try {
            objJson = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json processing error",e);
        }

        PrintWriter writer = null;
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Content-Type","application/json");
        try {
            writer = response.getWriter();
            writer.write(objJson);
        } catch (IOException e) {
            logger.error("response error",e);
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    public static String objectTojson(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        String objJson = null;
        try {
            objJson = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json processing error",e);
        }
        return objJson;
    }
}
