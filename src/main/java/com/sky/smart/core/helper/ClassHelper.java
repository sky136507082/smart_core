package com.sky.smart.core.helper;

import com.sky.smart.core.annotation.Action;
import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.annotation.Service;
import com.sky.smart.core.utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 2017/9/15.
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> controllerClassSet = new HashSet<Class<?>>();
        for (Class<?> cls : getClassSet()){
            if (cls.isAnnotationPresent(Controller.class)){
                controllerClassSet.add(cls);
            }
        }
        return controllerClassSet;
    }

    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> ServiceClassSet = new HashSet<Class<?>>();
        for (Class<?> cls : getClassSet()){
            if (cls.isAnnotationPresent(Service.class)){
                ServiceClassSet.add(cls);
            }
        }
        return ServiceClassSet;
    }

    public static Set<Class<?>> getBeansClassSet(){
        Set<Class<?>> beansClassSet = new HashSet<Class<?>>();
        beansClassSet.addAll(getControllerClassSet());
        beansClassSet.addAll(getServiceClassSet());
        return beansClassSet;
    }
}
