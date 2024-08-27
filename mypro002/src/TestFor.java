/*
   * 计算1-100之间的累加和，奇数和，偶数和！
 */
public class TestFor {
    public static void main(String[] args) {
        int sum = 0;//总和
        int oddsum =0;//奇数和
        int evensum = 0;//偶数和
        for (int i=0;i<101;i++){
            sum += i;

            if(i%2==0){
                evensum+=i;
            }else {
                oddsum += i;
            }
        }
        System.out.println("1到100之间的累加和"+sum);
        System.out.println("1到100之间的偶数和"+evensum);
        System.out.println("1到100之间的奇数和"+oddsum);
    }
}
