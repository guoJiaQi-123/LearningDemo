package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：面积差
 */

import java.util.Scanner;

public class CZHomeWork03 {

    public void area(double L){
        double areaSquare;
        double areaCircle;
        double r=L/2;
        if(L>0&&L<1000){
            areaSquare = L*L;
            areaCircle = r*r*3.14;
            double AreaDifference =areaSquare-areaCircle;
            System.out.println(AreaDifference);
        }else System.out.println("请正确输入1-1000之间的数");
    }

    public static void main(String[] args) {
        System.out.println("请输入一个1-1000之间的数：");
        Scanner scanner=new Scanner(System.in);
        double L =scanner.nextDouble();

        CZHomeWork03 czHomeWork03 =new CZHomeWork03();
        czHomeWork03.area(L);
    }
}
