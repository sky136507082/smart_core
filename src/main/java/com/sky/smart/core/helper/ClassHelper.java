package com.sky.smart.core.helper;

import com.sky.smart.core.annotation.Bean;
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
        Set<Class<?>> serviceClassSet = new HashSet<Class<?>>();
        for (Class<?> cls : getClassSet()){
            if (cls.isAnnotationPresent(Service.class)){
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    public static Set<Class<?>> getModelClassSet(){
        Set<Class<?>> modelClassSet = new HashSet<Class<?>>();
        for (Class<?> cls : getClassSet()){
            if (cls.isAnnotationPresent(Bean.class)){
                modelClassSet.add(cls);
            }
        }
        return modelClassSet;
    }

    public static Set<Class<?>> getBeansClassSet(){
        Set<Class<?>> beansClassSet = new HashSet<Class<?>>();
        beansClassSet.addAll(getControllerClassSet());
        beansClassSet.addAll(getServiceClassSet());
        beansClassSet.addAll(getModelClassSet());
        return beansClassSet;
    }
}
