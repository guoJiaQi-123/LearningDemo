import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlTest2 {
    public static void main(String[] args) throws Exception{
        URL url=new URL("https://www.itbaizhan.com/");
        try(BufferedReader br =new BufferedReader(new InputStreamReader(url.openStream()))){
            StringBuilder str = new StringBuilder();
            String temp ="";
            while ((temp = br.readLine())!=null){
                str.append(temp);
            }
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
