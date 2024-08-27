package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：IOUtils的妙用

 */

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class TestIOUtils {
    public static void main(String[] args) throws Exception{

        String string = IOUtils.toString(new FileInputStream("d:郭家旗.txt"), "utf-8");
        System.out.println(string);

    }
}
