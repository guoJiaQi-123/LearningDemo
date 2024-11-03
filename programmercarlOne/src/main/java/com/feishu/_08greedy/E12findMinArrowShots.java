package com.feishu._08greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version v1.0
 * @author OldGj 2024/11/3
 * @apiNote 452. 用最少数量的箭引爆气球
 */
public class E12findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        // 按照气球的右边界排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        // x是射箭的X坐标，每次贪心的从当前气球的最左边界射出
        int x = points[0][1];
        for (int[] point : points) {
            // 如果气球的右边界大于当前射箭的X坐标，此时该气球不会被射爆，需要调整射箭位置为当前气球的最左边界再次射出
            if (point[0] > x) {
                x = point[1];
                // 再次射出一次剪，res++
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[4][2];
        test[0] = new int[]{10, 16};
        test[1] = new int[]{2, 8};
        test[2] = new int[]{1, 6};
        test[3] = new int[]{7, 12};
        new E12findMinArrowShots().findMinArrowShots(test);
    }
}
