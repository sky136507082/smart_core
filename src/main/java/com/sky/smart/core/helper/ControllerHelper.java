package com.sky.smart.core.helper;

import com.sky.smart.core.annotation.Action;
import com.sky.smart.core.bean.Handler;
import com.sky.smart.core.bean.Request;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sky on 2017/9/15.
 */
public class ControllerHelper {
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();
    static {
        Set<Class<?>> controllerSet = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerSet)){
            for (Class<?> cls:controllerSet){
                Method[] methods = cls.getDeclaredMethods();
                for (Method method:methods){
                    if (method.isAnnotationPresent(Action.class)){
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        if(mapping.matches("\\w+:/\\w*")) {
                            String[] params = mapping.split(":");
                            if (ArrayUtils.isNotEmpty(params) && params.length == 2) {
                                String requestMethod = params[0];
                                String requestPath = params[1];
                                Request request = new Request(requestMethod, requestPath);
                                Handler handler = new Handler(cls, method);
                                ACTION_MAP.put(request, handler);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
