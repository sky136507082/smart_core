package com.sky.smart.core.helper;

import com.sky.smart.core.utils.ClassUtil;

/**
 * Created by sky on 2018/2/28.
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
