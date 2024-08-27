import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ObjectTypeServer {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(9999);) {


            byte[] bytes = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            //接收数据
            datagramSocket.receive(datagramPacket);

            //数据类型转换
            try (ObjectInputStream ois = new ObjectInputStream(
                    new ByteArrayInputStream(datagramPacket.getData()))) {
                Person person = (Person) ois.readObject();
                System.out.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
