import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class OneWaySocketClient {
    public static void main(String[] args) {
        try( //获取与服务端对应的socket对象
             Socket socket=new Socket("127.0.0.1",8888);
             //创建键盘输入对象
             Scanner scanner=new Scanner(System.in);
             //通过与服务端对应的socket对象创建字符输出流对象
             PrintWriter pw=new PrintWriter(socket.getOutputStream());
             //通过与服务端对应的socket对象创建字符输入流对象
             BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
             ){
            while (true){
                String str =scanner.nextLine(); //通过键盘输入获取需要向服务端发送的消息
                pw.println(str); //将消息发送到服务端
                pw.flush();
                if("quit".equals(str)){
                    break;
                }
                String readLine = br.readLine(); //读取服务端返回的消息
                System.out.println("服务端说："+readLine);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
