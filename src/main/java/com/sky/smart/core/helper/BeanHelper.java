package com.sky.smart.core.helper;

import com.sky.smart.core.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sky on 2017/9/15.
 */
public class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    static {
        Set<Class<?>> classSet = ClassHelper.getBeansClassSet();
        for (Class<?> cls : classSet){
            Object obj = ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }

    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static Object getBean(Class<?> cls){
        if (!BEAN_MAP.containsKey(cls))
            throw new RuntimeException("can not get bean by name: "+cls);
        return BEAN_MAP.get(cls);
    }
}
