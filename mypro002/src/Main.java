import java.util.*;

public class Main {
    public static void main(String[] args) {
       /*Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        int max;
        String result;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] <10){
                    if(arr[i]>arr[j]);

                }
            }

        }
*/
       /* Scanner scan =new Scanner(System.in);
        int num = scan.nextInt();
        String[] names = new String[num];
        for(int i=0;i<num;i++){
            names[i] = scan.next();
        }
        List<String> list =new ArrayList<>();
        for (int i=0;i<num;i++) {
            for(int j = i+1;j<num;j++){
                if(names[i].equals(names[j])){
                    list.add(names[i]);
                }
            }
        }
        System.out.println(list.toString());
*/

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        int result = 1;
        for(int i=0;i<n;i++){
            if(i==n-1){
                break;
            }
                if((arr[i+1]-arr[i])<=1||(arr[i+1]-arr[i])>=-1){
                    result++;
                }

        }
        System.out.println(result-2);
    }
}
