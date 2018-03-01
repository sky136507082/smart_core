package com.sky.smart.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by sky on 2018/2/28.
 */
public class StringUtil {
    public static boolean isEmpty(String chkStr) {
        if (chkStr != null) {
            chkStr = chkStr.trim();
        }

        return StringUtils.isEmpty(chkStr);
    }

    public static boolean isNotEmpty(String chkStr) {
       return !isEmpty(chkStr);
    }

    public String[] splitString(String str,String regex){
        if (isNotEmpty(str)){
            return str.split(regex);
        }
        return null;
    }
}
