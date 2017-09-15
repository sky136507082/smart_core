package com.sky.smart.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sky on 2017/9/14.
 */
public class CastUtil {
    private static final Logger logger = LoggerFactory.getLogger(CastUtil.class);

    public static String castString(Object obj ,String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static String castString(Object obj){
        return  castString(obj,"");
    }

    public static int castInt(Object obj, int defaultInt){
        int intValue = defaultInt;
        if (obj!=null){
            String tempValue = castString(obj);
            if (StringUtils.isNotEmpty(tempValue)){
               try{
                   intValue = Integer.parseInt(tempValue);
               } catch (NumberFormatException e){
                   intValue = defaultInt;
               }
            }
        }
        return intValue;
    }

    public static int castInt(Object obj){
        return castInt(obj,0);
    }

    public static double castDouble(Object obj, double defaultDouble){
        double intValue = defaultDouble;
        if (obj!=null){
            String tempValue = castString(obj);
            if (StringUtils.isNotEmpty(tempValue)){
                try{
                    intValue = Double.parseDouble(tempValue);
                } catch (NumberFormatException e){
                    intValue = defaultDouble;
                }
            }
        }
        return intValue;
    }

    public static double castDouble(Object obj){
        return castDouble(obj,0);
    }

    public static float castFloat(Object obj, float defaultFloat){
        float intValue = defaultFloat;
        if (obj!=null){
            String tempValue = castString(obj);
            if (StringUtils.isNotEmpty(tempValue)){
                try{
                    intValue = Float.parseFloat(tempValue);
                } catch (NumberFormatException e){
                    intValue = defaultFloat;
                }
            }
        }
        return intValue;
    }

    public static float castFloat(Object obj){
        return castFloat(obj,0);
    }

    public static boolean castBoolean(Object obj, boolean defaultBoolean){
        boolean intValue = defaultBoolean;
        if (obj!=null){
            String tempValue = castString(obj);
            if (StringUtils.isNotEmpty(tempValue)){
                try{
                    intValue = Boolean.parseBoolean(tempValue);
                } catch (NumberFormatException e){
                    intValue = defaultBoolean;
                }
            }
        }
        return intValue;
    }

    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }

    public static long castLong(Object obj, long defaultLong){
        long intValue = defaultLong;
        if (obj!=null){
            String tempValue = castString(obj);
            if (StringUtils.isNotEmpty(tempValue)){
                try{
                    intValue = Long.parseLong(tempValue);
                } catch (NumberFormatException e){
                    intValue = defaultLong;
                }
            }
        }
        return intValue;
    }

    public static long castLong(Object obj){
        return castLong(obj,0);
    }

}
