import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * 发送线程
 */
class Send1 extends Thread{
    private Socket socket;
    private Scanner scanner;
    public Send1(Socket socket, Scanner scanner){
        this.socket=socket;
        this.scanner=scanner;
    }

    @Override
    public void run() {
        this.send();
    }
    /**
     * 发送方法
     *
     */
    private void send(){
        try(PrintWriter pw =new PrintWriter(socket.getOutputStream())){
            while (true){
                String string = scanner.nextLine();
                pw.println(string);
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/**
 * 接收线程
 */
class Receive extends Thread{
    private Socket socket;

    public Receive(Socket socket){
        this.socket =socket;
    }
    @Override
    public void run() {
        this.receive();
    }
    /**
     * 接收方法
     */
    private  void receive(){
        try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            while (true){
                String readLine = br.readLine();
                System.out.println("他说："+readLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class GoodTCP {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket socket =null;
        Scanner scanner =null;
        try{
            scanner =new Scanner(System.in);
            System.out.println("请输入：server,<port>或者<IP>,<port>");
            String s =scanner.nextLine();
            String[] arr = s.split(",");
            if("server".equals(arr[0])){
                System.out.println("服务端以启动，正在监听"+arr[1]+"......");
                serverSocket =new ServerSocket(Integer.parseInt(arr[1]));
                socket = serverSocket.accept();
                System.out.println("连接成功");
            }else {
                socket =new Socket(arr[0],Integer.parseInt(arr[1]));
                System.out.println("客户端已启动，连接成功");
            }
            //启动接收线程
            new Receive(socket).start();
            new Send1(socket,scanner).start();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
