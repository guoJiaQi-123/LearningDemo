import java.net.URL;

public class UrlTest {
    public static void main(String[] args)throws Exception {
        URL url =new URL("https://www.itbaizhan.com/search.html?kw=java&page=1");
        System.out.println("得到这个 URL相关协议的默认端口号："+url.getDefaultPort());
        System.out.println("得到这 URL文件名:"+url.getFile());
        System.out.println("得到这 URL主机名称:"+url.getHost());
        System.out.println("得到这 URL路径:"+url.getPath());
        System.out.println("得到这 URL协议名称:"+url.getProtocol());
        System.out.println("参数:"+url.getQuery());
    }
}
