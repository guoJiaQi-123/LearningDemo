package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/04
 *本类内容：测试DateFormat
 */

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {

    public static void main(String[] args) throws ParseException {
        /*将字符串 转换为时间类型*/
        DateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//指定类型
        String birday = "2003-11-22 12:00:00";                             //字符串
        Date date = s1.parse(birday);                                      //字符串转时间用parse
        System.out.println(date);

        /*将时间类型转换为字符串*/
        DateFormat s2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");//指定类型
        Date date2 =new Date(12345678912L);                                      //时间类型
        String string =s2.format(date2);                                         //时间转字符串用format
        System.out.println(string);

        //小妙招
        DateFormat s3 = new SimpleDateFormat("今天是今年的第D天，第w周");//指定类型
        Date now =new Date();                                              //时间类型
        String now1 =s3.format(now);                                       //时间转字符串用format
        System.out.println(now1);
    }
}
