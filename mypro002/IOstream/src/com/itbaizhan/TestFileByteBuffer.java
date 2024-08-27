package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：字节缓冲区
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileByteBuffer {
    public static void main(String[] args) {
        long time1 =System.currentTimeMillis();
        FileCope("d:/1.png","d:/3.png");
        long time2 =System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    /***
     *
     * @param resource 源文件
     * @param desc     目标文件
     */
    public static void FileCope(String resource,String desc){
        //“后开的先关闭！”按照他们被创建顺序的逆序来关闭
        try(FileInputStream fis=new FileInputStream(resource);
            FileOutputStream fos =new FileOutputStream(desc)){
            // //创建一个缓冲区，提高读写效率
            byte[] buffer =new byte[1024];//缓冲区的长度一定是2的整数幂。一般情况下1024长度较为合适。
            int item =0;
            while ((item=fis.read(buffer))!=-1){
                //将缓存数组中的数据写入文件中，注意：写入的是读取的真实长度;
                fos.write(buffer,0,item);
            }
            fos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
