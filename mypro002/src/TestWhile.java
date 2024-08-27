/*
    *测试while循环的方法
 */
public class TestWhile {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (i<101){
            sum = sum +i;
            i++;
        }
        System.out.println("1到100的和为："+sum);
    }

}