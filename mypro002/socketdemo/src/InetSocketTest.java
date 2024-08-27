import java.net.InetSocketAddress;

public class InetSocketTest {
    public static void main(String[] args) {
        //创建一个InetSocketAddress对象
        InetSocketAddress inetSocketAddress=new InetSocketAddress("www.baidu.com",80);
        //获取IP地址
        System.out.println(inetSocketAddress.getAddress().getHostAddress());
        //获取计算机名
        System.out.println(inetSocketAddress.getHostName());
    }
}
