/*
    *测试switch语句
 */
public class TestSwitch02 {
    public static void main(String[] args) {
        int month = (int)(12*Math.random()+1);
        if (month<7){
            System.out.println(month+"月、上半年");
        }else {
            System.out.println(month+"月、下半年");
        }
        switch (month){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("上半年" );
                break;
            default:
                System.out.println("下半年");
                break;
        }
    }
}
