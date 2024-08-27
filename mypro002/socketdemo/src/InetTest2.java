import java.net.InetAddress;
/**
 * 根据域名获取计算机的信息
 */
public class InetTest2 {
    public static void main(String[] args) throws Exception{
        //实例化一个可以根据域名获取计算机信息的InetAddress对象
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");

        //返回该域名对应的计算机的IP地址
        System.out.println(inetAddress.getHostAddress());
        //获取计算机名称
        System.out.println(inetAddress.getHostName());
    }
}
