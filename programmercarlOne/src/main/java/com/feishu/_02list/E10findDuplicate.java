package com.feishu._02list;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/7/27
 * @apiNote 287. 寻找重复数
 */
public class E10findDuplicate {

    /*
        哈希表
        不满足题意条件使用O(1)的空间复杂度，但是如果有出现频率等问题还是需要考虑哈希表这种做法
     */
    public int findDuplicate(int[] nums) {
        // 【key - nums数组中的值，value - 出现的次数】
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            boolean containsKey = map.containsKey(num);
            if (containsKey) {
                return num; // 如果一个值已经出现过，则直接返回这个数
            } else {
                map.put(num, 1); // 如果没有出现过，则放入map集合中
            }
        }
        return 0;
    }

    /*
        二分查找
        鸽巢定理  11 个人住10个房间，那么必定有一个房间住着两个人
        nums的长度为n+1，nums中元素的值为[1，n]
     */
    public int findDuplicate2(int[] nums) {
        // 对于例子 [1,3,4,2,2]
        int len = nums.length;
        // 左闭右闭
        int left = 1;
        int right = len - 1;
        // [left,right] => [1,4] 数的范围
        while (left < right) {
            int mid = (left + right) / 2; // 二分的是数的范围
            int count = 0;
            // 遍历nums数组，记录nums数组中小于等于mid的数的个数
            // 如果mid=2，而nums数组中小于等于2的数有3个，则说明[1..2]区间肯定有重复数 -> 鸽巢定理
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 如果小于等于2的数大于2，则说明[1..2]区间有重复数，则right置为2
            if (count > mid) {
                right = mid;
            } else { // 如果小于等于2的数只有1个或者2个，则说明重复的数一定在[3..4]区间，则left置为mid+1
                left = mid + 1;
            }
        }
        // 如果left==right退出上面的循环，则返回的这个数一定为重复数
        return left; // 此时left == right
    }

    /*
        快慢指针
        题目中说明数组中的值范围在[1,n]之间，可以将nums的值作为索引，将nums数组构建为一个链表
        对于例子 [1,3,4,2,2]
           索引 [0,1,2,3,4]
        构建的链表为： 1 -> 3 -> 2 -> 4
                               |    |
                                <---
        构建链表解读：头结点1，以1为索引的值作为next节点，则第二个节点为3
                    以3为索引的值作为第三个节点，则第三个节点为2
                    以2为索引的值作为第四个节点，则第四个节点为4
                    以4为索引的值作为第五个节点，此时发现索引4的值也为2，形成一个有环链表，而第一个入环节点就是重复值
        为什么？
        如果以nums的值为索引，那么重复值出现两次以上，则会有两个以上索引指向同一个值，比如上面的例子
        索引3和索引4都指向2，则2一定作为两个节点的next节点，那么在链表中，一定会形成环，而且2就是入环的第一个节点
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0; // 快慢指针
        do {
            slow = nums[slow]; // 慢指针一次走一步
            fast = nums[nums[fast]]; // 快指针一次走两步
        } while (slow != fast);
        // 快慢指针相遇后，慢指针回链表头
        slow = 0;
        while (slow != fast) {
            // 快慢指针都一次走一步
            slow = nums[slow];
            fast = nums[fast];
        }
        // 返回再次相交的值就是重复值
        return slow;
    }
}
