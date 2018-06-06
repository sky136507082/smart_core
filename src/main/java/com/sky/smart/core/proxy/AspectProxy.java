package com.sky.smart.core.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by liansongyang on 2018/3/22.
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public final Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] methodParam = proxyChain.getMethodParam();

        begin(cls,method,methodParam);
        try{
            if (intercept(cls,method,methodParam)){
                before(cls,method,methodParam);
                result = proxyChain.doProxyChain();
                alert(cls,method,methodParam,result);
            }else{
                result = proxyChain.doProxyChain();
            }
        }catch (Exception e){
            logger.error("proxy failure",e);
            error(cls,method,methodParam,e);
            throw  e;
        }finally {
            end(cls,method,methodParam);
        }
        return result;
    }

    public void begin(Class<?> cls,Method method,Object[] methodParam) throws Throwable{

    }

    public boolean intercept(Class<?> cls,Method method,Object[] methodPara){
        return true;
    }

    public void end(Class<?> cls,Method method,Object[] methodPara){

    }

    public void before(Class<?> cls,Method method,Object[] methodPara){

    }

    public void alert(Class<?> cls,Method method,Object[] methodPara,Object result){

    }

    public void error(Class<?> cls,Method method,Object[] methodPara,Exception e){

    }
}
