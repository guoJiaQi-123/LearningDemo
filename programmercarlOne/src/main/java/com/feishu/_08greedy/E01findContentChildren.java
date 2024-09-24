package com.feishu._08greedy;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/9/24
 * @apiNote 455. 分发饼干
 */
public class E01findContentChildren {
    /*
        先讲饼干和孩子的胃口都升序排序
        每次取最小的饼干给胃口最小的孩子，如果不能满足胃口最小的孩子，则取下一块比当前饼干大的最小的饼干
        直到可以满足胃口最小的孩子，然后再处理下一个胃口最小的孩子
        贪心的思想：每次都用最小的饼干给胃口最小的孩子，这样能满足的孩子的个数最大
     */
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int h = 0;
        int b = 0;
        while (h < g.length && b < s.length) {
            if (s[b] >= g[h]) {
                count++;
                b++;
                h++;
            } else if (s[b] < g[h]) {
                b++;
            }
        }
        return count;
    }

    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            // 如果饼干可以满足当前孩子的胃口
            if (s[i] >= g[start]) {
                start++; // 指向孩子的指针++
                count++; // 满足的孩子的数量++
            }
        }
        return count;
    }

    public static void main(String[] args) {
        findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
    }
}
