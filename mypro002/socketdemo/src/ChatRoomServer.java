import sun.awt.geom.AreaOp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收客户端消息的线程类
 *  */
class ChatReceive extends Thread{
    private Socket socket;
    public ChatReceive(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        this.ChatReceiveMcg();
    }

    /**
     * 实现接收客户端发送的消息
     */
    private void ChatReceiveMcg(){
        try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            while (true){
                String readLine = br.readLine();
                synchronized ("abc"){
                    System.out.println(readLine);
                    //把读取到的数据写入公共数据区
                    ChatRoomServer.buff="["+socket.getInetAddress()+"]:"+readLine;
                    //唤醒发送消息的线程对象。
                    "abc".notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/**
 * 向客户端发送消息的线程类
 */
class ChatSend extends Thread{
    private Socket socket;
    public ChatSend(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        this.ChatSendMcg();
    }

    /**
     * 将公共数据区的消息发送给客户端
     */
    private void ChatSendMcg(){
        try(PrintWriter pw= new PrintWriter(socket.getOutputStream())){

            while (true){
                synchronized ("abc"){
                    //让发送消息的线程处于等待状态
                    "abc".wait();
                    //将公共数据区中的消息发送给客户端
                    pw.println(ChatRoomServer.buff);
                    pw.flush();


                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ChatRoomServer {
    //定义公共数据存放区
    public static String buff;

    public static void main(String[] args) {
        System.out.println("服务端启动，开始监听8888端口");
        try(ServerSocket serverSocket =new ServerSocket(8888);){
            while (true){
                int i=1;
                Socket socket = serverSocket.accept();
                System.out.println("成功与客户端"+(i++)+"取得连接");
                new ChatReceive(socket).start();
                new ChatSend(socket).start();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
