/*
   * 测试if双分支结构
*/
public class TestIf03 {
    public static void main(String[]args){
        int age = (int)(Math.random()*120);
        System.out.println(age);
        //15岁以下，儿童  15-24 青年 25-44 中年 45-64 中老年 65-84 老年 85-99 老寿星 100-109百岁老人 110以上 申请国家纪录
        if(age<15){
            System.out.println("儿童");
        } else if (age<25) {
            System.out.println("青年");
        } else if (age<45) {
            System.out.println("中年");
        }else if(age<65){
            System.out.println("中老年");
        }else if(age<85){
            System.out.println("老年");
        }else if(age<99){
            System.out.println("老寿星");
        }else if(age<110){
            System.out.println("百岁老人");
        }else{
            System.out.println("古来稀，申请国家纪录吧！");
        }
    }
}
