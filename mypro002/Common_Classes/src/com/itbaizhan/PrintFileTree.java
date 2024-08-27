package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：打印目录树
 */

import java.io.File;

public class PrintFileTree {
    public static void main(String[] args) {
        File file =new File("d:/电影");
        printFile(file,0);
    }

    static void printFile(File file,int level){
        for(int i =0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File file1[] = file.listFiles();//列出他的所有的子文件
            for (File file2:file1){         //for-each循环   用于遍历数组或者容器
                printFile(file2,level+1);
            }
        }
    }
}
