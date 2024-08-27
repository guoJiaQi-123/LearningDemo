import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 接收消息线程
 */
class ReceiveMessages extends Thread{
    private Socket socket;
    public ReceiveMessages(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
            this.receive_messages();
    }

    /**
     * 接收消息方法
     */
    private void receive_messages(){
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            while (true){
                String readLine = bufferedReader.readLine();
                System.out.println("他说："+readLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


/**
 * 发送消息线程
 */
class Send extends Thread{
    private Socket socket;
    public Send(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        this.Send_messages();
    }

    /**
     * 发送消息方法
     */
    private void Send_messages(){
        try(PrintWriter pw=new PrintWriter(socket.getOutputStream());
            Scanner scanner=new Scanner(System.in);){
            while (true){
                String s =scanner.nextLine();
                pw.println(s);
                pw.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ChatSocketServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(8888);//创建服务器对象监听8888端口
            ){
            System.out.println("等待连接");
            Socket socket = serverSocket.accept();//在（）外启动监听，主线程死亡，socket对象还在
            System.out.println("连接成功");
            new ReceiveMessages(socket).start();//启动接收消息线程
            new Send(socket).start();//启动发送消息线程
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
