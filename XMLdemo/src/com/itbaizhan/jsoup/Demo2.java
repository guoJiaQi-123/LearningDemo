package com.itbaizhan.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo2 {
    //Jsoup
    public static void main(String[] args) throws IOException {
        //1.解析本地XML文件
        String path = Demo2.class.getClassLoader().getResource("com/itbaizhan/xsd/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        System.out.println(document);
        //2.解析字符串
        System.out.println("-----------------------------------------");
        Document document1 = Jsoup.parse("<?xml version=\"1.0\" ?>\n" +
                "<students xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "          xsi:schemaLocation=\"http://www.itbaizhan.cn/xml student.xsd\"\n" +
                "          xmlns=\"http://www.itbaizhan.cn/xml\">\n" +
                "    <student number=\"baizhan_0001\">\n" +
                "        <name>百战</name>\n" +
                "        <age>10</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "    <student number=\"baizhan_0002\">\n" +
                "        <name>尚学堂</name>\n" +
                "        <age>10</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "</students>\n");
        System.out.println(document1);
        System.out.println("--------------------------------");
        //3.解析网络资源，给定URL
        Document document2 = Jsoup.parse(new URL("https://www.itbaizhan.com/course/id/38912.html"),4000);
        System.out.println(document2);
    }
}
