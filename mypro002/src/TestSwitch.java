/*
  *测试switch语句的方法
 */
public class TestSwitch {
    public static void main(String[] args) {
        String computer = "联想";
        switch (computer){
            case "联想":
                System.out.println("人类没有联想怎么办");
                break;
            case"华为":
                System.out.println("进入华为");
                break;
            default:
                System.out.println("其他品牌");
                break;
        }
    }
}
