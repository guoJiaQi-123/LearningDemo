//生成 0-100 随机数，直到生成 88 为止，停止循环！
public class HomeWork02 {
    public static void main(String[] args) {
        int j=0;
        while(true){
            int i=(int)(Math.random()*100+1);
            System.out.println(i);
            j++;
            if (i==88){
                break;
            }

        }
        System.out.println("第"+j+"次为88");
    }
}
