import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ObjectTypeClient {
    public static void main(String[] args) {
        try(DatagramSocket datagramSocket =new DatagramSocket();
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)){
            //实例化Person对象
            Person person =new Person();
            person.setAge(18);
            person.setName("oldLu");
            oos.writeObject(person);
            //将自定义数据类型转换为字节数组类型
            byte[] byteArray = bos.toByteArray();
            //将自定义数据类型包装到DatagramPacket中
            DatagramPacket datagramPacket=new DatagramPacket(byteArray,byteArray.length,new InetSocketAddress("127.0.0.1",9999));
            //发送数据
            datagramSocket.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
