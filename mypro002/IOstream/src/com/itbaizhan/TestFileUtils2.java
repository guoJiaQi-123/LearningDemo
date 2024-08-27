package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：使用FileUtils工具类实现目录拷贝
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TestFileUtils2 {
    public static void main(String[] args) throws IOException {
        FileUtils.copyDirectory
                (new File("d:/mycode"), new File("d:/mycode2"), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith("java")){
                    return true;
                }else {
                    return false;
                }
            }
        });
    }
}
