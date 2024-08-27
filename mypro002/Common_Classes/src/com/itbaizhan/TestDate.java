package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/04
 *本类内容：时间类
 */

import com.sun.org.apache.xml.internal.dtm.DTMFilter;

import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//距离1970年1.1过来多少毫秒

        Date date1 = new Date();
        System.out.println(date1);//打印当前的时间

        Date date2=new Date(33L*365*12*2*60*60*1000);
        System.out.println(date2);

        //equals   比较两个时间是否相等
        System.out.println(date1.equals(date2));
        //before   after  时间是否在前/后
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
    }
}
