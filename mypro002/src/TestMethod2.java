/*
    *测试方法的定义与调用
    * 定义一个方法处理公司的迟到问题：
    (1) 输入：迟到时间，月薪。
    (2) 处理逻辑：
    ① 迟到1-10分钟，警告。
    ② 迟到11-20分钟，罚款100元。
    ③ 迟到21分钟-30分钟，罚款200元。
    ④ 迟到30分钟以上，扣除半日工资。
    ⑤ 迟到1小时以上，按照旷工计算，扣除3日工资。
    (3) 输出：罚款金额
 */
public class TestMethod2 {
    public static int handleLate(int lateTime,int monthsalary){
        System.out.println("迟到时间："+lateTime+"(min)");
        System.out.println("月薪："+monthsalary+"人民币");
        int fakuan = 0;
        int daySalary = (int)(monthsalary/22.5);
        if(lateTime<=10){
            System.out.println("警告");
        }else if(lateTime<=20){
            System.out.println("罚款100元");
            fakuan=100;
        }else if(lateTime<=30){
            System.out.println("罚款200元");
            fakuan=200;
        }else if(lateTime<=60){
            System.out.println("罚款半日工资："+daySalary/2);
            fakuan = daySalary/2;
        }else {
            System.out.println("罚款一日工资"+daySalary);
            fakuan = daySalary;
        }
        return fakuan;

    }

    public static void main(String[] args) {
        int a = handleLate(12,34000);
        int b = handleLate(78,87000);
        int c = handleLate(45,45000);
        System.out.println("总罚款金额："+(a+b+c));
    }
}
