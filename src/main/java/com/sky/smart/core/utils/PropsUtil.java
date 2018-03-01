package com.sky.smart.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by sky on 2017/9/14.
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    private PropsUtil(){
    }

    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException(fileName+" file is not found");
            }

            properties = new Properties();
            properties.load(is);
        }catch (IOException e) {
            logger.info("load properties file failure",e);
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                logger.info("close input stream failure",e);
            } catch (NullPointerException e){
                logger.info("close input stream failure",e);
            }
        }
        return properties;
    }

    public static String getString(Properties prop,String key,String defaultValue){
        String value = defaultValue;
        if (prop.containsKey(key)){
            value = CastUtil.castString(prop.getProperty(key));
        }
        return value;
    }

    public static String getString(Properties prop,String key){
        return getString(prop,key,"");
    }


    public static double getDouble(Properties prop,String key,double defaultValue){
        double value = defaultValue;
        if (prop.containsKey(key)){
            value = CastUtil.castDouble(prop.getProperty(key));
        }
        return value;
    }

    public static double getDouble(Properties prop,String key){
        return getDouble(prop,key,0);
    }


    public static float getFloat(Properties prop,String key,float defaultValue){
        float value = defaultValue;
        if (prop.containsKey(key)){
            value = CastUtil.castFloat(prop.getProperty(key));
        }
        return value;
    }

    public static float getFloat(Properties prop,String key){
        return getFloat(prop,key,0);
    }

    public static boolean getBoolean(Properties prop,String key,boolean defaultValue){
        boolean value = defaultValue;
        if (prop.containsKey(key)){
            value = CastUtil.castBoolean(prop.getProperty(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties prop,String key){
        return getBoolean(prop,key,false);
    }


}
