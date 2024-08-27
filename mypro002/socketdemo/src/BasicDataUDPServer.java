import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BasicDataUDPServer {
    public static void main(String[] args) {

        try(DatagramSocket datagramSocket =new DatagramSocket(9999);){
            //创建字节数组缓冲区
            byte[] bytes = new byte[1024];
            //创建datagramPacket存放字节数组类型的数据
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
            //等待客户端传入数据
            datagramSocket.receive(datagramPacket);
            //实现数据类型转换
            try(DataInputStream dataInputStream =new DataInputStream(new ByteArrayInputStream(bytes))){
                //通过基本数据数据流对象获取传递的数据
                System.out.println(dataInputStream.readLong());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
