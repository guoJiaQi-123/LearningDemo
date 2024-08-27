package com.itbaizhan.ajax.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 自定义序列化类
 */
public class GenderJsonSerializer extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (o.equals(1)) {
            jsonGenerator.writeString("男");
        } else if (o.equals(0)){
            jsonGenerator.writeString("女");
        }
    }
}
