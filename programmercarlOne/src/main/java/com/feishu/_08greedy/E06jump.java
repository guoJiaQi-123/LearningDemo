package com.feishu._08greedy;

/**
 * @version v1.0
 * @author OldGj 2024/9/29
 * @apiNote 45. 跳跃游戏 II
 */
public class E06jump {
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) { // 最大的覆盖距离已经可以到达终点，直接跳到可以到达最大覆盖距离的那个位置
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    /*
        用最少的步数，走到最远地覆盖位置
        3 3 1 1 4
        - - - -
          - - - -
              -
                -
        （先把当前可以走到的最远位置走了，在走的过程中，记录下一步可以走到的最远距离）-》 走第一步的3的时候，找到了可以走的更远的距离>第二个3和第二个1
        （如果当前的最远距离走完，发现没有到达尾部（第一个3最远走到了第二个1，走不到终点，不得不count++），则继续向下一步可以走到的最远距离走，此时需要count++，表示走到了可以走到更远的那个位置了【这里表示走到了第二个3或者第二个1那里了，都行！】）
     */
    public int jump(int[] nums) {
        int count = 0;
        // 当前覆盖的最远距离下标
        int curr = 0;
        // 下一步覆盖的最远距离下标
        int next = 0;
        for (int i = 0; i <= curr && curr < nums.length - 1; i++) {
            // 在走的过程中，记录下一步可以走到的最远距离
            next = Math.max(next, i + nums[i]);
            // 最大的覆盖距离已经可以到达终点，说明当前一步，再跳一步就到达了末尾，直接跳到可以到达最大覆盖距离的那个位置
            if (next >= nums.length - 1) {          // 参考方案1得出的
                count++;            // 参考方案1得出的
                break;          // 参考方案1得出的
            }           // 参考方案1得出的
            // 可达位置的改变次数就是跳跃次数
            if (i == curr) {
                curr = next;
                count++;
            }
        }
        return count;
    }
}
