/*
   * 测试break的方法
   * 产生100以内的随机数，直到随机数为88时终止循环

 */
public class TestBreak {
    public static void main(String[] args) {


        int total = 0;

        while(true){

            total++;
            int i = (int)(Math.random()*100+1);
            System.out.println(i);
            if(i==88){
                break;
            }

        }
    System.out.println("循环次数:"+total);
    }
}
