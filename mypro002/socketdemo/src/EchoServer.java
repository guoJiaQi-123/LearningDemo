import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 处理消息线程
 *
 */
class Mag extends Thread{
    private Socket socket;
    public Mag(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        this.Mag();
    }
    /**
     * 处理消息方法
     *
     */
    private void Mag(){
        try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ; PrintWriter pw=new PrintWriter(socket.getOutputStream());){
            while (true){
                pw.println(br.readLine()+"  [ok]");
                pw.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(this.socket.getInetAddress()+" 已断开连接");
        }
    }
}
public class EchoServer {
    public static void main(String[] args) {
        System.out.println("服务端已启动，监听8888........");
        try(ServerSocket serverSocket=new ServerSocket(8888)){
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("连接成功");
                new Mag(socket).start();
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
