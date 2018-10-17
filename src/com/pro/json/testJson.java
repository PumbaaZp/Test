package com.pro.json;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class testJson {
    public static void main(String args[]){
        //Map<String, Object> map = JSONObject.parseObject(JSONObject.toJSONString("{\"ownerName\":\"\",\"provinceCode\":\"330000\",\"ownerId\":\"\"}"), Map.class);
        Map<String, Object> map = JSONObject.parseObject("{\"ownerName\":\"\",\"provinceCode\":\"330000\",\"ownerId\":\"\"}", Map.class);
        
        System.out.println("aaa");
    }
}
