/*
  *测试嵌套语句的方法
 */
public class TestLoop01 {
    public static void main(String[] args) {

        for(int i=1;i<=5;i++){
            for(int m =0;m<5;m++){
                System.out.print(i+"\t");
            }
            System.out.println();
        }


        //打印九九乘法表
        for(int m=1;m<=9;m++){
            for(int n=1;n<=m;n++){
                System.out.print(m+"*"+n+"="+m*n+"\t");
            }System.out.println();
        }


        //打印*方阵
        for (int n = 0;n<5;n++){
            for (int m=0;m<5;m++){
                System.out.print("*"+"\t");
            }
            System.out.println();
        }
System.out.println("*****************************************");
        //打印*  #间隔方阵
        int count =0;
        for (int n=0;n<25;n++){
            if (n%2==0){
                System.out.print("*"+"\t");
            }else {
                System.out.print("#"+"\t");
            }
            count++;
            if (count%5==0){
                System.out.println();
            }
        }
    }
}
