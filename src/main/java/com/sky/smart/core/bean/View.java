package com.sky.smart.core.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 2018/2/28.
 */
public class View {

    private String path;

    private Map<String,Object> model;

    public View(String path){
        this.path = path;
        model = new HashMap<String,Object>();
    }

    public View addModel(String key,Object value){
        this.model.put(key,value);
        return this;
    }

    public String getPath(){
        return this.path;
    }

    public Map<String,Object> getModel(){
        return model;
    }
}
