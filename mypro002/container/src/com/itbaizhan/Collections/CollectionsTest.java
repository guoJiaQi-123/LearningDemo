package com.itbaizhan.Collections;/*
 *作者：郭家旗
 *时间：2023/09/12
 *本类内容：测试Collections工具类
 */import com.itbaizhan.set.Student;import com.itbaizhan.set.StudentComparator;
import com.itbaizhan.set.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("d");
        list.add("c");
        Collections.sort(list);//String类内部做了比较规则
        for(String s :list){
            System.out.println(s);
        }
        System.out.println("------------------");
        List<User> list2=new ArrayList<>();
        User user =new User("郭家旗",20);
        User user1 =new User("苏红润",19);
        User user2 =new User("王旭伟",20);
        list2.add(user);
        list2.add(user2);
        list2.add(user1);
        Collections.sort(list2);
        for(User u:list2){
            System.out.println(u);
        }
        System.out.println("-------------------");
        List<Student> list3 = new ArrayList<>();
        Student student =new Student("gjq",20);
        Student student1 =new Student("shr",19);
        Student student2 =new Student("wxw",20);
        Student student3 =new Student("ghq",21);
        list3.add(student);
        list3.add(student1);
        list3.add(student2);
        list3.add(student3);
        Collections.sort(list3,new StudentComparator());
        for(Student s:list3){
            System.out.println(s);
        }

        System.out.println("----------------");
        List<String> list4=new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        list4.add("d");
        list4.add("e");
        Collections.shuffle(list4);//顺序随机
        for (String s :list4){
            System.out.println(s);
        }

    }
}
