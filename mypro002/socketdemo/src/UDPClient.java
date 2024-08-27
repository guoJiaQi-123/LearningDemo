import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) {
        //创建数据发送对象 DatagramSocket,需要指定消息的发送端口
        try(DatagramSocket datagramSocket =new DatagramSocket(8887)){

            //发送的内容转换为字节数组数据类型
            byte[] bytes = "百战程序员".getBytes();
            //创建数据报包
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length,
                    new InetSocketAddress("127.0.0.1",9999));
            datagramSocket.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
