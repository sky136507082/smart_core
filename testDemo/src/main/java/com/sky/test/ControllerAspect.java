package com.sky.test;

import com.sky.smart.core.annotation.Aspect;
import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by liansongyang on 2018/3/23.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);

    private long time;

    @Override
    public void begin(Class<?> cls, Method method, Object[] methodParam) throws Throwable {
        System.out.println("---------- begin ----------");
        System.out.println(String.format("class: %s",cls.getName()));
        System.out.println(String.format("method: %s",method.getName()));
        time = System.currentTimeMillis();
    }

    @Override
    public void end(Class<?> cls, Method method, Object[] methodPara) {
        System.out.println(String.format("time: %dms", System.currentTimeMillis()-time));
        System.out.println("---------- end ----------");
    }
}
