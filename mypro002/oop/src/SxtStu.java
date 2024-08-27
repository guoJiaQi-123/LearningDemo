/*
    *一个简单的类
 */
public class SxtStu {
    //定义类的属性，也叫成员变量
    int id;
    int age;
    String sname;
    //定义类的方法
    public void study(){
        System.out.println("正在学习，勿扰！！");
    }
    public void kickball(){
        System.out.println("踢球中，为我加油！！");
    }

    public static void main(String[] args) {
        SxtStu s1 =new SxtStu();
        System.out.println(s1.id);
        System.out.println(s1.sname);
        s1.id=1001;
        s1.sname="郭家旗";
        System.out.println(s1.id);
        s1.kickball();
    }
}
