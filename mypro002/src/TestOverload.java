/*
    *测试重载的方法
 */
public class TestOverload {
    public static void main(String[] args) {


    }
    public static void add(int a){

    }
    public static void add(){

    }
    public static int add(int a,int b){
        int c=a+b;
        return c;
    }                                    //只有返回值不同，不构成方法的重载
    public static double add1(int a,int b){
        return a;
    }
}
