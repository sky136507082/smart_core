package com.sky.smart.core.helper;

import com.sky.smart.core.annotation.Inject;
import com.sky.smart.core.utils.ReflectionUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by sky on 2017/9/15.
 */
public class IocHelper {
    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getFields();
                if (ArrayUtils.isNotEmpty(beanFields)){
                    for (Field beanField : beanFields){
                        if (beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance!=null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
