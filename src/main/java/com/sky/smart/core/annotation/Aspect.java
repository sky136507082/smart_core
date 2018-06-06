package com.sky.smart.core.annotation;

import java.lang.annotation.*;

/**
 * Created by liansongyang on 2018/3/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();

}
