package com.feishu._11graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @version v1.0
 * @author OldGj 2024/8/13
 * @apiNote 743. 网络延迟时间
 */
public class E01networkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 定义一个无穷大的值，用于初始化距离数组
        final int INF = Integer.MAX_VALUE / 2;
        // 定义一个邻接表，用于存储图
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<int[]>();
        }
        // 遍历times数组，将每个边的信息存入邻接表
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        // 定义一个距离数组，用于存储每个节点到源节点的距离
        int[] dist = new int[n];
        // 将距离数组初始化为无穷大
        Arrays.fill(dist, INF);
        // 将源节点的距离设置为0
        dist[k - 1] = 0;
        // 定义一个优先队列，用于存储每个节点到源节点的距离和节点编号
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        // 将源节点放入优先队列
        pq.offer(new int[]{0, k - 1});
        // 当优先队列不为空时，循环
        while (!pq.isEmpty()) {
            // 从优先队列中取出距离源节点最近的节点
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            // 如果当前节点的距离已经更新，则跳过
            if (dist[x] < time) {
                continue;
            }
            // 遍历当前节点的邻接节点
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                // 如果当前邻接节点的距离比已知距离小，则更新距离，并将该节点放入优先队列
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{d, y});
                }
            }
        }

        // 找出距离数组中的最大值，即为最长的延迟时间
        int ans = Arrays.stream(dist).max().getAsInt();
        // 如果最大值等于无穷大，则说明存在无法到达的节点，返回-1
        return ans == INF ? -1 : ans;
    }

}
