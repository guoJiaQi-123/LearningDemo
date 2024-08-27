//使用递归算法完成阶乘：1!+2!+3!+4!+5!


public class HomeWork03 {
    public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=5;i++){
            sum=sum+factoral(i);//利用for循环计算1-5的阶乘
        }
        System.out.println("1!+2!+3!+4!+5!="+sum);
    }
    public static int factoral(int a){//阶乘的递归算法
        if(a==1){
        return 1;}
        else {
            return a*factoral(a-1);
        }
    }
}
