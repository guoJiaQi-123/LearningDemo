import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OneWaySocketServer {
    public static void main(String[] args) {
        System.out.println("服务端启动，正在监听");
        //创建服务端对象
        try(ServerSocket ss=new ServerSocket(8888);
            //开始监听8888端口，获与取客户端对应的Socket对象
            Socket socket = ss.accept();
            //通过与客户端对应的socket对象创建字符输入流
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //通过与客户端对应的socket对象创建字符输出流
            PrintWriter pw=new PrintWriter(socket.getOutputStream())){
            System.out.println("连接成功！！");
            while (true){
                String s = br.readLine(); //读取客户端发送的消息
                if("quit".equals(s)){
                    break;
                }
                System.out.println("客户端说："+s);
                pw.println(s);
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }
}
