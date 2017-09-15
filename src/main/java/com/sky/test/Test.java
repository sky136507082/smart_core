package com.sky.test;

import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.helper.BeanHelper;
import com.sky.smart.core.helper.ClassHelper;
import com.sky.smart.core.helper.ControllerHelper;
import com.sky.smart.core.helper.IocHelper;
import com.sky.smart.core.utils.ClassUtil;
import com.sky.smart.core.utils.ReflectionUtil;

import java.util.Set;

/**
 * Created by sky on 2017/9/14.
 */
public class Test {
    public static void main(String str[]){
      Class<?>[] clsArray = {ClassHelper.class,BeanHelper.class, IocHelper.class,ControllerHelper.class};
      for (Class<?> cls : clsArray){
          ClassUtil.loadClass(cls.getName(),false);
      }

      Set<Class<?>> set =   ClassUtil.getClassSet("com.sky.test");
      System.out.println(set.size());
      for (Class<?> cls :set){
          System.out.println(ReflectionUtil.newInstance(cls).toString());
      }
    }
}
