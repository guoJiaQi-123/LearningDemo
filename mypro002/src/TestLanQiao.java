//成绩统计
import java.text.NumberFormat;
import java.util.Scanner;
public class TestLanQiao {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
/*        Double i = scan.nextDouble();
        Double i_copy=i;
        Double j = 0.0;
        Double y = 0.0;
        while (true){
            int anInt = scan.nextInt();
            if(anInt>=85){
                y++;
            }
            if(anInt>=60){
                j++;
            }
            if(--i_copy==0.0){
                break;
            }
        }
        if (j == null || i == null || i <= 0) {
            System.out.println("0%");
        }
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(0);
        percent.setMinimumFractionDigits(0);
        System.out.println(percent.format(j / i));
        System.out.println(percent.format(y / i));*/
        int n =scan.nextInt();
        int score;
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            score=scan.nextInt();
            if(score>=85){
                sum1++;
            }
            if(score>=60){
                sum2++;
            }
        }
        System.out.println(Math.round(sum2*100/n)+"%");
        System.out.println((int)(sum1*100.0/n+0.5)+"%");

    }
}
