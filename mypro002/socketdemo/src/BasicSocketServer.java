import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicSocketServer {
    public static void main(String[] args) {
        System.out.println("服务器启动，等待监听....");
        //创建ServerSocket
        try ( ServerSocket serverSocket=new ServerSocket(1122);
              ////监听8888端口，此时线程会处于阻塞状态。
              Socket socket = serverSocket.accept();
              //连接成功后会得到与客户端对应的Socket对象，并解除线程阻塞。
              //通过客户端对应的Socket对象中的输入流对象，获取客户端发送过来的消息。
              BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            System.out.println(br.readLine());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("服务器启动失败....");
        }
    }
}
