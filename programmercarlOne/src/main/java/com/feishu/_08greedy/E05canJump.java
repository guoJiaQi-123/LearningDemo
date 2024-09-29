package com.feishu._08greedy;

/**
 * @version v1.0
 * @author OldGj 2024/9/29
 * @apiNote 55. 跳跃游戏
 */
public class E05canJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) { // 注意这里是小于等于cover
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) { // 说明可以覆盖到终点了
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean canJump = new E05canJump().canJump(new int[]{1, 2, 3});
        System.out.println(canJump);
    }
}
