package com.tyut._03hashtable;

import java.io.*;
import java.util.Scanner;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 55.右旋字符串 - 》 卡码网
 */
public class E05rightHanded {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int k = nextInt();
        String s = nextLine();
        String s1 = s.substring(0, s.length() - k);
        String s2 = s.substring(s.length() - k);
        String sb = s2 + s1;
        pw.println(sb);
        pw.close();
    }


    public static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }


}
