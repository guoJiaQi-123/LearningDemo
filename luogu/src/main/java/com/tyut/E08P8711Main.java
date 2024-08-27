package com.tyut;

import java.io.*;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8711 [蓝桥杯 2020 省 B1] 整除序列
 */
public class E08P8711Main {
    static BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer =new StreamTokenizer(bufferedReader);
    static PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception{
        //代码实现
        long n = nextLong();
        while (n != 0) {
            pw.print(n+" ");
            n = n >> 1;
        }
        pw.flush();
    }

    public static String nextLine() throws Exception{
        return bufferedReader.readLine();
    }

    public static int nextInt() throws Exception{
        streamTokenizer.nextToken();
        return (int)streamTokenizer.nval;
    }

    public static long nextLong() throws Exception{
        streamTokenizer.nextToken();
        return (long) streamTokenizer.nval;
    }

    public static double nextDouble() throws Exception{
        streamTokenizer.nextToken();
        return streamTokenizer.nval;
    }
    public static String next() throws Exception {
        streamTokenizer.nextToken();
        return streamTokenizer.sval;
    }
}
