package 异常;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class checked {
    public static void main(String[] args){
        FileReader fr=null;
        try {
            fr=new FileReader("d:/suhongrun.txt." );
            char c1=(char)fr.read();
            char c2=(char)fr.read();
            char c3=(char)fr.read();
            System.out.println(""+c1+c2+c3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

