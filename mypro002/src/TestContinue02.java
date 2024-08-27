/*
   *带标签的continue
 */
public class TestContinue02 {
    public static void main(String[] args) {
        //打印100到150之间所有的质数
        a:for(int i =100;i<150;i++){

            for(int n=2;n<i;n++){
                if(i%n==0){
                    continue a;
                }

            }
        System.out.println(i);
        }
    }
}
