//用while和 for 循环分别计算100以内奇数和偶数的和，并输出。

public class HomeWork01 {
    public static void main(String[] args) {
        int i=0;
        int sumji=0;
        int sumou=0;
        while(i<100){           //while循环
            if (i%2==0){
                sumou+=i;
            }else {
                sumji+=i;
            }
            i++;
        }
        System.out.println("奇数和："+sumji+"\t"+"偶数和："+sumou);
        int i1=0;
        int sum_ji=0;
        int sum_ou=0;
        for(i1=0;i1<100;i1++){    //for循环
            if (i1%2==0){
                sum_ou+=i1;
            }else sum_ji+=i1;
        }
        System.out.println("奇数和："+sum_ji+"\t"+"偶数和："+sum_ou);
    }
}
