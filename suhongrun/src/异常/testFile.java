package 异常;

import javax.xml.transform.Source;
import java.io.File;
import java.util.Date;

public class testFile {
    public static void main(String[] args) {
        File f1=new File("d:/a.txt");
        System.out.println("File是否存在"+f1.exists());
        System.out.println("File是否是文件"+f1.isFile());
        System.out.println("File是否是目录"+f1.isDirectory());
        System.out.println("File大小"+f1.length());
        System.out.println("File最后的更改时间"+new Date(f1.lastModified()));
        System.out.println("File文件名"+f1.getName());
        System.out.println("File目录路径"+f1.getAbsolutePath());


    }
}
