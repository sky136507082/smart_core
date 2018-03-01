package com.sky.smart.core.bean;

import com.sky.smart.core.utils.CastUtil;

import java.util.Map;

/**
 * Created by sky on 2018/2/28.
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(this.paramMap.get(name));
    }

    public Map<String,Object> getMap(){
        return paramMap;
    }
}
