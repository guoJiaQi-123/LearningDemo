package com.itbaizhan;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.Arrays;
//利用javabean和数组保存表格数据
public class Array07 {

    public static void main(String[] args) {
        Emp[] emps={new Emp(1001,"郭家旗",20,"学生","2022"),
                    new Emp(1002,"苏红润",19,"学生","2022"),
                    new Emp(1003,"lisa",20,"学生","2023")};
        for(Emp e:emps){
            System.out.println(e);
        }
    }

}
class Emp{
    private int ID;
    private String name;
    private int age;
    private String job;
    private String entry_time;

    @Override    //重写toString方法
    public String toString() {
        return "Emp{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", entry_time='" + entry_time + '\'' +
                '}';
    }

    public Emp(int ID, String name, int age, String job, String entry_time) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.job = job;
        this.entry_time = entry_time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }
}