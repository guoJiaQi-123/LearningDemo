import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String luanma = scan.nextLine();
        String name = scan.next();
        int indexOf = luanma.indexOf(name);
        if(indexOf==-1){
            System.out.println("未找到");
        }else {
            System.out.println("名字的位置在第"+(indexOf+1)+"个字符的地方");
        }

    }
}
