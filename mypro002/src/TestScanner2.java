import java.util.Scanner;
public class TestScanner2 {
    public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String string1 = s.nextLine();
    String s2 = s.nextLine();
    int i = s.nextInt();
    System.out.println(string1);
    System.out.println(s2);
    System.out.println(i*10);
    }
}