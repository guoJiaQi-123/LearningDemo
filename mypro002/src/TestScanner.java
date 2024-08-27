/*
  年薪计算器
 */
import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入月薪：");
        double monthSalary = scanner.nextDouble();
        System.out.println("用户名为："+uname);
        System.out.println("年龄为："+age);
        System.out.println("您的年薪为："+monthSalary*12);
    }
}
