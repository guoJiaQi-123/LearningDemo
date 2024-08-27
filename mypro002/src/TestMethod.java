/*
   *测试方法的定义与调用
 */
public class TestMethod {
    public static void main(String[] args) {
        System.out.println("I Love U！！！");
        System.out.println("我爱你");
        System.out.println("520");
        sayLove();  //调用方法
        sayLove();
        add(5,6,8);
    }
    public static void sayLove(){  //定义一个sayLove方法
        System.out.println("I Love U！！！");
        System.out.println("我爱你");
        System.out.println("520");
    }

    public static int add(int a,int b,int c){
        int sum = a + b+ c;
        System.out.println("sum:"+sum);
        return sum;     //return两个作用  1.返回值   2.结束方法运行
    }
}
