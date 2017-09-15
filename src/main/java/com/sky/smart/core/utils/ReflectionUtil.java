package com.sky.smart.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sky on 2017/9/15.
 */
public class ReflectionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);
    
    public static Object newInstance(Class<?> cls){
        Object obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            logger.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static Object invokeMethod(Object obj, Method method,Object... args){
        Object result = null;
        try {
            result = method.invoke(obj,args);
        } catch (Exception e) {
            logger.error("invoke method failure",e);
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void setField(Object obj ,Field field,Object args){
        try {
            field.setAccessible(true);
            field.set(obj,args);
        } catch (Exception e) {
            logger.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
