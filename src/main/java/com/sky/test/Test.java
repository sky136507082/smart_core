package com.sky.test;

import com.sky.smart.core.utils.ClassUtil;

import java.util.Set;

/**
 * Created by sky on 2017/9/14.
 */
public class Test {
    public static void main(String str[]){
        Set<Class<?>> classSet = ClassUtil.getClassSet("com.sky.smart.core");
        System.out.println("size:"+classSet.size());
        for(Class cls : classSet){
            System.out.println(cls.getName());
        }
    }
}
