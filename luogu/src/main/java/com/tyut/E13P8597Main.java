package com.tyut;

import java.io.*;
import java.util.Arrays;

/**
 * @author OldGj 2024/03/21
 * @version v1.0
 * @apiNote P8597 [蓝桥杯 2013 省 B] 翻硬币
 */
public class E13P8597Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String old_str = nextLine();
        String new_str = nextLine();
        int count = 0;
        for (int i = 0; i < old_str.length(); i++) {
            if (old_str.charAt(i) != new_str.charAt(i)) {
                old_str = reverse(old_str, i);
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }

    public static String reverse(String str, int i) {
        char[] charArray = str.toCharArray();
        if (charArray[i] == '*') {
            charArray[i] = 'o';
        } else {
            charArray[i] = '*';
        }
        if (charArray[i + 1] == '*') {
            charArray[i + 1] = 'o';
        } else {
            charArray[i + 1] = '*';
        }
        return String.valueOf(charArray);
    }

    public static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }
}
