package com.usst.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonHelper {

    private JsonHelper(){}

    public static String object2str(Object object){

        String retStr = "";

        ObjectMapper mapper = new ObjectMapper();

        //把对象转换成str，必须有setter和getter方法
        try {
            retStr = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return retStr;
    }

    public static Object str2Object(String str, Class clazz){
        Object object = null;
        ObjectMapper mapper = new ObjectMapper();

        //把字符串转成对象
        try {
            object = mapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
