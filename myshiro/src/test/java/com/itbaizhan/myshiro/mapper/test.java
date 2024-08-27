package com.itbaizhan.myshiro.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class test {
    @Test
    void test()throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] a = new int[n + 1];
            String[] s = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(s[i - 1]);
            }
            int res = Integer.MAX_VALUE;
            for (int i = 1; i <= 60; i++) {
                int cnt = 0;
                int[] b = new int[n + 1];
                for (int j = 1; j <= n; j++) {
                    b[j] = a[j];
                }
                for (int j = 1; j <= n; j++) {
                    if (b[j] != i) {
                        for (int h = j; h <= Math.min(j + k - 1, n); h++) {
                            b[h] = i;
                        }
                        j = j + k - 1;
                        cnt++;
                    }
                }
                res = Math.min(res, cnt);
            }
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
