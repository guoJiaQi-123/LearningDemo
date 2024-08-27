
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TwoWaySocketServer {
    public static void main(String[] args) {
        System.out.println("服务器启动，监听8888端口");
        try(ServerSocket serverSocket=new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            //获取键盘输入对象
            Scanner scanner=new Scanner(System.in);
            //通过与客户端对应的socket对象，创建输入流
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //通过与客户端对应的socket对象，创建输出流
            PrintWriter pw=new PrintWriter(socket.getOutputStream());
        ){
            System.out.println("连接成功");
            while (true){

                String readLine = br.readLine(); //读取客户端发送的消息
                System.out.println("客户端说："+readLine);

                String outPut =scanner.nextLine();//发送到客户端
                pw.println(outPut);
                pw.flush();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
