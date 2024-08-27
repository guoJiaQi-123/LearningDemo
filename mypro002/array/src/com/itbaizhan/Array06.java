package com.itbaizhan;
//测试Object[][]存储表格数据
import java.util.Arrays;
public class Array06 {

    public static void main(String[] args) {
        Object[] a1={2022005946,"郭家旗","软件2235"};
        Object[] a2={2022005400,"苏红润","软件2221"};

        Object[][] objects;
        objects=new Object[2][];
        objects[0]=a1;
        objects[1]=a2;
        System.out.println(Arrays.toString(objects[0]));
        System.out.println(Arrays.toString(objects[1]));
        System.out.println("////////////////////");
        for(int i=0;i<objects.length;i++){
            for(int j=0;j<objects[i].length;j++){
                System.out.print(objects[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
