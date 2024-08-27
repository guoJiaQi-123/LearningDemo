package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：自定义异常（不合法的年龄异常）继承Exception类
 */

public class IllegalAgeException extends Exception{
    //默认构造器
    public IllegalAgeException() {

    }

    //带有详细信息的构造器，信息存储在message中
    public IllegalAgeException(String message) {
        super(message);
    }
}
