/**
 * 薪水计算器
 * (1)通过键盘输入用户的月薪，每年是几个月薪水。
 * (2)输出用户的年薪
 * (3)输出一行字“如果年薪超过10万，恭喜你超越90%的国人”，“如果年薪超过20万，恭喜你超越98%的国人”。
 * (4)直到键盘输入数字88，则退出程序（使用break退出循环）
 * (5)键盘输入66，直接显示“重新开始计算...”，然后算下一个用户的年薪。
 */
import java.util.Scanner;
public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("**********年薪计算器**********");
        while (true){
            System.out.println("请输入您的月薪：");
            int Salayrmonths = s.nextInt();
            System.out.println("请输入您每年有几月的薪资：");
            int Months = s.nextInt();
            System.out.println("您的年薪为："+Salayrmonths*Months);

            if(Salayrmonths*Months>200000){
                System.out.println("恭喜你超越98%的国人");
            } else if (Salayrmonths*Months>100000) {
                System.out.println("恭喜你超越90%的国人");
            }
            System.out.println("输入88，退出程序\n输入66，继续下次计算");
            int comm = s.nextInt();
            if(comm==88){
                System.out.println("程序已退出");
                break;
            }else if(comm==66){
                System.out.println("继续下一次计算");
                continue;
            }else{
                System.out.println("请输入有效数字！！");
                break;
            }
        }


    }
}
