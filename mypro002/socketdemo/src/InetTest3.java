import java.net.InetAddress;

public class InetTest3 {
    public static void main(String[] args )throws Exception {
        //创建一个根据IP地址获取计算机信息的InetAddress对象
        InetAddress inetAddresses = InetAddress.getByName("182.61.200.7");
        //返回IP地址
        System.out.println(inetAddresses.getHostAddress());
        //返回计算机名
        System.out.println(inetAddresses.getHostName());
    }
}
