import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入（1-100）：");
        int i =(int) (Math.random()*100)+1;
        int start = 1;
        int end = 100;
        while (true){
            int number = scanner.nextInt();
            if (number == i) {
                System.out.println("你猜对了");
                break;
            }
            if (number > i) {
                if(number>end){
                    System.out.println("请输入正确的数！！(小于："+end+")");
                }else {
                    System.out.println("该数在" + start + "-" + number + "之间");
                    end = number;
                }
            } else {
                if(number<start){
                    System.out.println("请输入正确的数！！(大于："+start+")");
                }
                else {
                    System.out.println("该数在" + number + "到" + end + "之间");
                    start = number;
                }
            }
        }
    }
}
