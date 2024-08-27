/*
  测试for循环的方法
 */
public class TestFor01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0;i<101;i++){
            sum += i ;
        }
        System.out.println("1到100之间数的累加和："+sum);
        //输出9-1之间的数
        for (int i1 = 9;i1>0;i1--){
            System.out.print(i1+"\t");
        }
        System.out.println();//换行
        //输出90-1中能被3整除的数
        for(int i2 = 90;i2>0;i2-=3){
            System.out.print(i2+"\t");
        }
        System.out.println();
        for (int i3=90;i3>0;i3--){
            if (i3%3==0){
                System.out.print(i3+"\t");
            }
        }
    }
}
