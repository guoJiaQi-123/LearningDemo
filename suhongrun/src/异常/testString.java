package 异常;

public class testString {
    public static void main(String[] args) {
        String str="";
        long num1=Runtime.getRuntime().freeMemory();
        long time1= System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            str=str+i;
        }
        long num2=Runtime.getRuntime().maxMemory();
        long time2=System.currentTimeMillis();
        System.out.println("String占用内存："+(num2-num1));
        System.out.println("String运行时间："+(time2-time1));
        StringBuilder sb=new StringBuilder();
        long num3=Runtime.getRuntime().freeMemory();
        long time3=System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            sb.append(i);
        }
        long num4=Runtime.getRuntime().freeMemory();
        long time4=System.currentTimeMillis();
        System.out.println("StringBuilder占用内存："+(num3-num4));
        System.out.println("StringBuilder运行时间："+(time3-time4));
    }
}
