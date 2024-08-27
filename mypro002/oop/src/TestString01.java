public class TestString01 {
    public static void main(String[] args) {
        String s = "i love Su";
        String s1 = "i love su";
        String s2 = "i love java";
        System.out.println(s1.charAt(5));                       //返回字符串中第几个字符
        System.out.println(s1.equals(s2));  //比较两个字符串是否相等//如果字符串s1与s2相等则返回true,否则返回false
        System.out.println(s1.equalsIgnoreCase(s));             //忽略大小写，判断两个字符串是否相等
        System.out.println(s2.length());//11                     //输出字符串长度
        /*indexOf  返回从头开始查找第一个子字符串str在字符串中的索引位置。如果未找到子字符串str，则返回-1。*/

        System.out.println(s2.indexOf("java"));//7
        System.out.println(s1.indexOf("java"));//-1
        /*lastindexOf 返回从末尾开始查找第一个子字符串str在字符串中的索引位置。如果未找到子字符串str，则返回-1。*/
        String s3 = "i love java and java love me";
        System.out.println(s3.lastIndexOf("java"));//16
        System.out.println(s3.indexOf("java"));//7


    }

}
