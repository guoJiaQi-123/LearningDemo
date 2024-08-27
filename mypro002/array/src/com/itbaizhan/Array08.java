package com.itbaizhan;
        //测试Comparable接口
import java.util.Arrays;

public class Array08 {

    public static void main(String[] args) {
        Man2[] msMans={new Man2(20,"郭家旗"),
                   new Man2(19,"苏红润")};

        Arrays.sort(msMans);
        System.out.println(Arrays.toString(msMans));
    }
}
class Man2 implements Comparable{
    int age;
    String name;

    public Man2(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int compareTo(Object o){
        Man2 man2 = (Man2) o;
        if(this.age<man2.age){
            return -1;
        }
        if(this.age>man2.age){
            return 1;
        }
        return 0;

    }
}