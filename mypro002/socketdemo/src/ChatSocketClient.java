import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * 接收消息线程
 */
class ReceiveMessage extends Thread{
    private Socket socket;
    public ReceiveMessage(Socket socket){
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
class Sends extends Thread{
    private Socket socket;
    public Sends(Socket socket){
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



public class ChatSocketClient {
    public static void main(String[] args) {
        try{
            System.out.println("等待连接");
            Socket socket =new Socket("127.0.0.1",8888);
            System.out.println("连接成功");
            new Sends(socket).start();
            new ReceiveMessage(socket).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
