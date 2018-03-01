package com.sky.smart.core.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sky on 2018/2/28.
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection){
        return CollectionUtils.isNotEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?,?> map){
        return MapUtils.isNotEmpty(map);
    }

    public static boolean isEmpty(Object[] arrays){
        return ArrayUtils.isEmpty(arrays);
    }

    public static boolean isNotEmpty(Object[] arrays){
        return ArrayUtils.isNotEmpty(arrays);
    }

    public static void main(String[] param){
        System.out.println(CollectionUtil.isEmpty(new String[]{"0"}));
    }
}
