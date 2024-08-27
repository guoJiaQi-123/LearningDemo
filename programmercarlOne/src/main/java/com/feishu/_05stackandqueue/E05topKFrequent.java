package com.feishu._05stackandqueue;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 347. 前 K 个高频元素
 */
public class E05topKFrequent {

    // 解法0：基于大顶堆，大顶堆里面放Entry对象
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 大顶堆，堆里面放Entry对象，Entry对象中的key:元素，value:出现频率
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());// 按照频率从大到小排
        // 将entry按照出现频率大小比较加入大顶堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        // 大顶堆中弹出的前K个元素就是出现频率最高的K个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    //解法1：基于大顶堆实现，堆里面放数组，数组长度为2
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // 计算频率
        }
        //在优先队列中存储数组[num, cnt],num表示元素值 cnt表示元素出现频率
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) { //依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = maxHeap.poll()[0];
        }
        return ans;
    }

    //解法2：基于小顶堆实现，堆里面放数组，数组长度为2
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储数组[num, cnt],num表示元素值 cnt表示元素出现频率
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //小顶堆只需要维持k个元素有序
            if (pq.size() < k) { //小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // 小顶堆元素个数大于k个时，添加需要判断当前元素出现频率和堆顶元素哪个大，如果当前元素大，则替换堆顶元素
                if (entry.getValue() > pq.peek()[1]) { //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll(); //弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
