package com.itbaizhan.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    // 获取XML中所有学生的姓名
    public static void main(String[] args) throws IOException {
        // 2.加载XML文档进内存。获取DOM树对象Document
        // 2.1 获取类加载器
        ClassLoader classLoader = Demo1.class.getClassLoader();
        // 2.2使用类加载器，找到XML文档的路径
        String path = classLoader.getResource("com/itbaizhan/xsd/student.xml").getPath();
        // 2.3加载XML文档进内存，并转成Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3.获取对应的标签Element对象
        Elements name = document.getElementsByTag("name");
        // 4.获取数据
        for(Element element:name){
            String text = element.text();
            System.out.println(text);
        }
    }
}
