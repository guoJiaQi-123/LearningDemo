package com.feishu._05stackandqueue;

import com.tyut._06stackandqueue.E05evalRPN;
import com.tyut._06stackandqueue.E06maxSlidingWindow;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 239. 滑动窗口最大值
 */
public class E04maxSlidingWindow {
    /**
     *  单调递减队列
     */
    static class MonotonicStack {
        // 双端队列
        private final LinkedList<Integer> deque = new LinkedList<>();

        // 查看递减队列的第一个元素
        public Integer peek() {
            return deque.peekFirst();
        }

        // 查看并移除递减队列的第一个元素
        public void poll() {
            deque.pollFirst();
        }

        // 向递减队列中添加元素
        public void offer(Integer m) {
            // 队尾元素如果小于待添加元素，则出队
            while (!deque.isEmpty() && deque.peekLast() < m) {
                deque.pollLast();
            }
            deque.offerLast(m);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列
        MonotonicStack queue = new MonotonicStack();
        // 结果集合
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 滑动窗口前面的一个元素就是nums[ i - k ]
            // 如果滑动窗口前面的第一个元素等于了队列中的最大值，说明这个最大值已经出了滑动窗口范围
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            queue.offer(num);
            // 从i >= k-1 开始，每次将队列中的最大值加入结果集合
            if (i >= k - 1) {
                list.add(queue.peek());
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
