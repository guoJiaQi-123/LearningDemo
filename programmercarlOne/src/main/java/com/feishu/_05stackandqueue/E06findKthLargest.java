package com.feishu._05stackandqueue;

import java.util.PriorityQueue;

/**
 * @version v1.0
 * @author OldGj 2024/8/10
 * @apiNote 215. 数组中的第K个最大元素 - 使用小顶堆
 */
public class E06findKthLargest {

    /*
        大体思路：使用小顶堆存放数组中前K大的元素，那么第K大个元素就是小顶堆堆顶的元素
     */
    @SuppressWarnings("all")
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 先把前k个元素加入小顶堆
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            // 如果后面的元素有比堆顶元素大的，则替换堆顶元素
            if (nums[i] > minHeap.peek()) {
                minHeap.remove(minHeap.peek());
                minHeap.offer(nums[i]);
            }
        }
        // 最后堆顶元素就是第K大元素
        return minHeap.peek();
    }
}
