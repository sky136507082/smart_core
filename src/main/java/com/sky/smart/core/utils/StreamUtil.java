package com.sky.smart.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sky on 2018/2/28.
 */
public class StreamUtil {
    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream is){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine())!=null){
                stringBuilder.append(line);
            }
        }catch (Exception e){
            logger.error("get String failure", e);
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }
}
