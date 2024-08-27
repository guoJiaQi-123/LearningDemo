import java.util.Scanner;

/*1．求平均年龄
01星球有学长若干名，给出每个学长的年龄，求O1星球学长的平均年龄，保留小数点后两位输入∶
第一行:整数n(1<n<100)，表示人数
之后n行:每行一个整数a(15<a<55)，表示第n个学长的年龄输出:
一个浮点数，保留两位小数．表示01星球学长平均年龄
样例输入∶
3
18
18
17
样例输出:17.67
*/
public class CZHomeWork {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int a=scanner.nextInt();
        double sum=0;

        int b[]=new int[a];
        for (int i=0;i<a;i++) {
            b[i] = scanner.nextInt();
            sum += b[i];
        }
        double result=sum/a;
        String str =String.format("%.2f",result);
        System.out.println(str);
    }
}
