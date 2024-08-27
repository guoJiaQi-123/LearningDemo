/*
    *测试switch语句的方法
 */
public class TestSwitch01 {
    public static void main(String[] args) {
        int grade = (int)(Math.random()*4+1);
        switch (grade){
            case 1:
                System.out.println("大一！！！");
                break;
            case 2:
                System.out.println("大二！！！");
                break;
            case 3:
                System.out.println("大三！！！");
                break;
            case 4:
                System.out.println("大四！！！");
                break;
        }
    }
}
