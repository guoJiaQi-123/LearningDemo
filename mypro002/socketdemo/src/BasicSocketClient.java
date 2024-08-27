import java.io.PrintWriter;
import java.net.Socket;

public class BasicSocketClient {
    public static void main(String[] args) {
        //创建Socket对象
        try(Socket socket =new Socket("127.0.0.1",1122);
            //创建向服务端发送消息的输出流对象。
            PrintWriter pw=new PrintWriter(socket.getOutputStream())){
            pw.println("你好!服务端");
            pw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
