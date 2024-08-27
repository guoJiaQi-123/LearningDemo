public class TestString02 {
    public static void main(String[] args) {
        String s1 = "i love Su";
        String s2 = "i love su";
        String s3 = "i love java";
        String t1 = s1.replace("Su","Guo");//替换字符串里面的字符，生成一个新的字符串
        System.out.println(t1);
        System.out.println(s1.startsWith("i"));            //如果字符串以prefix开始，则返回true。
        System.out.println(s1.startsWith("I"));
        System.out.println(s3.endsWith("java"));            //如果字符串以prefix结尾，则返回true。
        String t2 = s1.toUpperCase();                       //将字符串中所有字母大写，生成新字符串
        System.out.println(t2);
        String t3 = s1.toLowerCase();                       //将字符串中所有字母小写，生成新字符串
        System.out.println(t3);
        String t4 = s3.substring(7);               //输出从索引为7开始的所有字符 ，生成新字符串
        String t5 = s3.substring(7,10);                      //输出索引为[7,10)的字符串，生成新字符串
        System.out.println(t4);
        System.out.println(t5);
        String s4 = "     牛逼     百战      ";
        String t6 = s4.trim();                               //删除首尾空格
        System.out.println(t6);
    }
}
