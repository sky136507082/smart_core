package com.sky.smart.core.proxy;

/**
 * Created by liansongyang on 2018/3/22.
 */
public interface Proxy {
    /**
     * 执行链式代理
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
