package 异常;

import java.util.Random;

public class enumTest {
    public static void main(String[] args) {
        //遍历枚举
        for (Season s:Season.values()) {
            System.out.println(s);
        }
        int a=new Random().nextInt(4);
        switch (Season.values()[a]){
            case SPRING:
                System.out.println("春天");break;
            case SUMMER:
                System.out.println("夏天");break;
            case AUTUMN:
                System.out.println("秋天");break;
            case WINNER:
                System.out.println("冬天");break;
        }
    }
    enum Season{
        SPRING,SUMMER,AUTUMN,WINNER;
    }
}
