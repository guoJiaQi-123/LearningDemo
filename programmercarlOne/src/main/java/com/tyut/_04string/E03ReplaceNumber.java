package com.tyut._04string;

import java.io.*;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 54. 替换数字 -> 卡码网
 */
public class E03ReplaceNumber {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String s = nextLine();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                sb.append("number");
            }
        }
        pw.println(sb);
        pw.close();
    }

    static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }
}
