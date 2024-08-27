package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：
 */

public class TestMath {

    public static void main(String[] args) {
        /*          取整相关                      */
        System.out.println(Math.floor(3.2));          //小于这个数的最大整数
        System.out.println(Math.ceil(3.2));           //大于这个数的最小整数
        System.out.println(Math.round(3.2));         //round四舍五入
        System.out.println(Math.round(3.8));

        /*           //绝对值、开方、a的b次幂等操作                 */
        System.out.println(Math.abs(-45)); //取绝对值
        System.out.println(Math.sqrt(64)); //开方
        System.out.println(Math.pow(2,5)); //2的5次方
        System.out.println(Math.pow(5,2));

        /*Math类中常用的常量*/
        System.out.println(Math.PI);
        System.out.println(Math.E);

        /*  取随机数   */             /*  [0,1)   */
        System.out.println(Math.random());
    }
}
