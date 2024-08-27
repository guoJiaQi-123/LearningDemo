import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TwoWaySocketClient {
    public static void main(String[] args) {
        System.out.println("客户端启动，连接本机的8888端口");
        //创建客户端对象，连接8888端口
        try(Socket socket =new Socket("127.0.0.1",8888);
            //创建键盘输入对象
            Scanner scanner =new Scanner(System.in);
            //通过与服务端对应的socket创建输入流对象
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //通过与服务端对应的socket创建输出流对象
            PrintWriter pw=new PrintWriter(socket.getOutputStream());
        ){
            System.out.println("连接成功");
            while (true){
                //通过键盘获取信息
                String string = scanner.nextLine();
                //发送信息给服务端
                pw.println(string);
                pw.flush();

                //接收服务端发来的信息
                String readLine = br.readLine();
                System.out.println("服务端说："+readLine);
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
