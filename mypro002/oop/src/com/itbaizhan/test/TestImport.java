package com.itbaizhan.test;
/*
* 测试导入
* */
import com.itbaizhan.oop.car;
import java.util.*;  //导入这个包下所有的类，会降低编译速度但不会降低运行速度
public class TestImport {
    com.itbaizhan.oop.car c3 = new com.itbaizhan.oop.car(); //如果不导入包，建立对象时需要打出完整包名，非常麻烦
    //如果有重复的类名，也需要打出完整包名以示区分
    car c1 = new car();
    car c2 = new car();
}
