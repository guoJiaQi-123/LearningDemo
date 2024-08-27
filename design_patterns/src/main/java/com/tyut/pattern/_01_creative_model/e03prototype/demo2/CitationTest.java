package com.tyut.pattern._01_creative_model.e03prototype.demo2;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 测试类
 */
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建原型对象
        Citation citation = new Citation();
        // 通过原型对象克隆对象
        Citation citation1 = citation.clone();


        citation.setName("张三");
        citation1.setName("李四");


        citation.show();
        citation1.show();
    }
}
