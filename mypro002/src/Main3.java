import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scan.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
