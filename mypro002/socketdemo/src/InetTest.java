/**
 * 通过InetAddress类获取本机信息
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
    public static void main(String[] args) {
        //实例化一个InetAddress对象
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        //输出当前计算机的IP地址
        System.out.println(inetAddress.getHostAddress());
        //输出本机的计算机名
        System.out.println(inetAddress.getHostName());
    }
}
