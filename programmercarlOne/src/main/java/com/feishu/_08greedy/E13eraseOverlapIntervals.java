package com.feishu._08greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version v1.0
 * @author OldGj 2024/11/3
 * @apiNote 435. 无重叠区间
 */
public class E13eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 将所有区间按照右区间边界排序
        Arrays.sort(intervals, Comparator.comparingInt(r -> r[1]));
        int res = 1; // 无重复区间的个数
        // 无重叠区间的右边界
        int y = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 说明：如果遍历的区间左边界小于y，说明当前区间与y所在的区间一定是有重叠的，因为当前区间的右边界一定大于y「排好序的」
            // 如果遍历的区间左边界大于等于定义的y，说明找到了一个无重复区间
            if (intervals[i][0] >= y) {
                // 更新y的值为当前区间的右边界
                y = intervals[i][1];
                res++;
            }
        }
        // 区间总个数 - 无重复区间个数 = 要移除区间的个数
        return intervals.length - res;
    }
}
