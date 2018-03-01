package com.sky.smart.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by sky on 2018/2/28.
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将 POJO 转为 Json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
        String json = null;
        
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("convert POJO to Json failure",e);
            throw new RuntimeException(e);
        }
        
        return json;
    }

    public static <T> T fromJson(String json,Class<T> type){
        T pojo = null;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (IOException e) {
            logger.error("convert Json to POJO failure",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }

}
