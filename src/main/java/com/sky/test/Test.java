package com.sky.test;

import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.helper.BeanHelper;
import com.sky.smart.core.helper.ClassHelper;
import com.sky.smart.core.helper.ControllerHelper;
import com.sky.smart.core.helper.IocHelper;
import com.sky.smart.core.utils.ClassUtil;
import com.sky.smart.core.utils.ReflectionUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 2017/9/14.
 */
public class Test {
    public static void main(String str[]){
      Class<?>[] clsArray = {ClassHelper.class,BeanHelper.class, IocHelper.class,ControllerHelper.class};
      Set<Class<?>> set = new HashSet<Class<?>>();
      for (Class<?> cls : clsArray){
          set.add(ClassUtil.loadClass(cls.getName(),false));
      }

      System.out.println(set.size());

      ClassUtil.getClassSet("com.sky.smart.test");
      TestController testController = (TestController) BeanHelper.getBean(TestController.class);
      System.out.println(testController);

    }
}
