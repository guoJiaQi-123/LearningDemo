package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：Apache commons-io工具包的使用-FileUtils类
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestFileUtils {
    public static void main(String[] args) throws IOException {
        String s = FileUtils.readFileToString(new File("d:/郭家旗.txt"), "utf-8");
        System.out.println(s);
    }
}
