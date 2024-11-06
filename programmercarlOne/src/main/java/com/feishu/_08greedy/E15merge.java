package com.feishu._08greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @author OldGj 2024/11/4
 * @apiNote 56. 合并区间
 */
public class E15merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();

        // 按照区间的左边界将区间排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        // 默认加入第一个区间
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 如果后面的区间的左边界 小于等于 前面的区间的右边界，说明有区间重叠
            if (intervals[i][0] <= res.getLast()[1]) {
                // 合并后的区间左边界为前面区间的左边界（因为是排好序的）
                int left = res.getLast()[0];
                // 合并后的区间右边界为两个重叠区间的更大的右边界；
                int right = Math.max(res.getLast()[1], intervals[i][1]);
                // 删除最后一个区间
                res.removeLast();
                // 加入合并后的区间
                res.addLast(new int[]{left, right});
            } else {
                // 没有区间重叠，直接添加
                res.addLast(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new E15merge().merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}});
    }
}
