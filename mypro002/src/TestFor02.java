/*
   for循环作业
 */
public class TestFor02 {
    public static void main(String[] args) {
        //打印1-130之间的数，每行显示5个数字
        /*
        int i;
        for(i =130;i>0;i--){
            if(i%5==0){
                System.out.println("\n");
                System.out.print(i+"\t");
            }else {
                System.out.print(i+"\t");
            }

        }
        */
        int count = 0;//每行打印几个数，记为几
        int i2;
        for (i2=1;i2<131;i2++){
            System.out.print(i2+"\t");
            count++;
            if (count==5){
                System.out.println("\n");
                count=0;
            }
        }
    }
}
