package com.sky.smart.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by sky on 2018/2/28.
 */

public final class CodecUtil {
    private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将 URL 编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target;

        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("encode url failure",e);
            throw new RuntimeException(e);
        }

        return target;
    }

    public static String decodeURL(String source){
        String target;

        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("decode url failure",e);
            throw new RuntimeException(e);
        }

        return target;
    }

}
