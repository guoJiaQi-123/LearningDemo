/*
    静态初始化块
 */
public class TestStatic2 {
    static String company;
    static {
        System.out.println("加载类的时候就会执行");
        TestStatic.company="百战程序员";
        TestStatic.printCompany();
    }
    static void printCompany(){
        System.out.println(company);
    }

    public static void main(String[] args) {

    }
}
