package com.tyut._06stackandqueue;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 239. 滑动窗口最大值
 */
public class E06maxSlidingWindow {
    public static void main(String[] args) {
        E06maxSlidingWindow e06maxSlidingWindow = new E06maxSlidingWindow();
        int[] ints = e06maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *  单调递减队列
     */
    static class MonotonicStack {
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
            while (!deque.isEmpty() && deque.peekLast() < m) {
                deque.pollLast();
            }
            deque.offerLast(m);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 3 -1 -3
        // 单调队列
        MonotonicStack queue = new MonotonicStack();
        // 结果集合
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 如果滑动窗口前面的第一个元素等于了队列中的最大值，说明这个最大值已经出了滑动窗口范围
            // 需要弹出该元素
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            queue.offer(num);
            // 从i >= k-1 开始，每次将队列中的最大值加入结果集合
            if (i >= (k - 1)) {
                list.add(queue.peek());
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


}
