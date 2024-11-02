package com.feishu._08greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @version v1.0
 * @author OldGj 2024/11/2
 * @apiNote 406. 根据身高重建队列
 */
public class E11reconstructQueue {
    // 算法的结果如果需要两个维度才能确定，我们应该想办法先确定其中一个维度，并且保证这个维度在第二个维度改变的时候不会影响到他
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，会根据k值升序排列
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的状况会根据h值降序排列
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);   // Linkedlist.add(index, value)，会將value插入到指定index里。
        }
        return que.toArray(new int[people.length][]);
    }
}
