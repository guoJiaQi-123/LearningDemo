import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSever {
    public static void main(String[] args) {
        //创建服务端接收数据的DatagramSocket对象
        try(DatagramSocket datagramSocket =new DatagramSocket(9999)){
            //创建数据缓存区
            byte[] buf=new byte[1024];

            //创建DatagramPocket对象包装数据（创建数据报包对象）
            DatagramPacket datagramPacket =new DatagramPacket(buf,buf.length);
            //等待接收服务端发送的数据
            datagramSocket.receive(datagramPacket);
            //获取被包装的数据
            byte[] data = datagramPacket.getData();
            //转换为字符串类型
            String s=new String(data,0,datagramPacket.getLength());
            System.out.println(s);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
