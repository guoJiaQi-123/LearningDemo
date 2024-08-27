package com.itbaizhan.ajax.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * 自定义反序列化类
 */
public class GenderJsonDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        if(jsonParser == null){
            return null;
        }
        int sex = 0;
        switch (jsonParser.getText()){
            case "男":
                sex = 1;
                break;
            case "女":
                break;
            default:
                throw new RuntimeException("传入的性别值不合法");
        }
        return sex;
    }
}
