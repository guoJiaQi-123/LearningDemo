/*
  *测试if语句单分支结构的方法
  * 掷筛子游戏
 */
public class TestIf01 {
    public static void main(String[] args){
        int i = (int)(Math.random()*6+1);
        int j = (int)(Math.random()*6+1);
        int k = (int)(Math.random()*6+1);
        int count = i+j+k;
        System.out.println("第一次点数为："+i);
        System.out.println("第二次点数为："+j);
        System.out.println("第三次点数为："+k);
        if(count>15){
            System.out.println("手气很好！！！");
        }
        if(count>10&&count<=15){
            System.out.println("手气一般，再来两把！！");
        }
        if(count<=10){
            System.out.println("手气太差了！！");
        }
        System.out.println("本次共获得点数："+count);
    }
}
