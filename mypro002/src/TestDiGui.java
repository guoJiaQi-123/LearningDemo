/*

   *测试递归的用法
 */
public class TestDiGui {
    public static void main(String[] args) {
        long result =factorial(5);;

        System.out.println(result);

    }
    public static long factorial(int n){
        if (n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
}
