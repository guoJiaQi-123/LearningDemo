package 异常;

import java.io.File;

public class testFile2 {
    public static void main(String[] args) {
        File f=new File("C:\\Users\\HX\\IdeaProjects\\suhongrun");
        printFile(f,0);
    }
    public static void printFile(File file,int level){
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        //如果file是目录，则获取子文件列表，并对每个子文件进行相同的操作
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for (int i = 0; i < files.length; i++) {
                printFile(files[i],level+1);
            }
        }
    }
}
