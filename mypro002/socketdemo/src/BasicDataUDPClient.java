import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class BasicDataUDPClient {
    public static void main(String[] args) {
        //创建发送数据的DatagramSocket对象
        try(DatagramSocket datagramSocket = new DatagramSocket(8856);
            //创建将基本数据类型转换为字节数组的ByteArrayOutputStream对象
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            //创建将基本数据类型写入ByteArrayOutputStream中的数据输出流对象
            DataOutputStream dataOutputStream =new DataOutputStream(byteArrayOutputStream)){
            //要传递的数据
            long data=10000l;
            //写入ByteArrayOutputStream对象
            dataOutputStream.writeLong(data);
            //将基本数据类型转换为字节数组
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            //将字节数组包装到 DatagramPacket中
            DatagramPacket datagramPacket=new DatagramPacket(byteArray,byteArray.length
            , new InetSocketAddress("127.0.0.1",9999));
            //发送数据
            datagramSocket.send(datagramPacket);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
