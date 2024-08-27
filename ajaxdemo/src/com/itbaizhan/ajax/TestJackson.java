package com.itbaizhan.ajax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbaizhan.ajax.pojo.Element;
import com.itbaizhan.ajax.pojo.TestBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestJackson {

    public static void main(String[] args) throws JsonProcessingException, ParseException {
//        String s1 = "2002-12-31 23:23:23";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = format.parse(s1);
//
//        Element element = new Element();
//        element.setAge(23);
//        element.setEname("zhangsan");
//        element.setUpdateTime(date);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(element);
//        System.out.println(s);

        TestBean testBean = new TestBean();
        testBean.setId("1");
        testBean.setName("zhangsan");
        testBean.setSex(2);

        ArrayList<Element> list = new ArrayList<>();
        Element element = new Element();
        element.setEname("zhangsan");
        element.setAge(23);
        list.add(element);
        testBean.setElements(list);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(testBean);
        System.out.println(s);


//        String str = "{\n" +
//                "\t\"id\": 1,\n" +
//                "\t\"name\": \"\",\n" +
//                "\t\"sex\": \"女\",\n" +
//                "\t\"elements\": [{\n" +
//                "\t\t\"age\": 22,\n" +
//                "\t\t\"ename\": \"xiaozhang\"\n" +
//                "\t}, {\n" +
//                "\t\t\"age\": 23,\n" +
//                "\t\t\"ename\": \"xiaosan\"\n" +
//                "\t}]\n" +
//                "}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        TestBean testBean = objectMapper.readValue(str, TestBean.class);
//        System.out.println(testBean);
    }
}
