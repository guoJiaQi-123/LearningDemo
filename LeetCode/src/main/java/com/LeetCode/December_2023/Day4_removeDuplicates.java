package com.LeetCode.December_2023;

import java.util.*;

//删除排序数组中的重复项
public class Day4_removeDuplicates {

    //暴力解法
   public static int removeDuplicates(int[] nums) {
        //定义一个变量len，用来存储数组的长度
        int len = nums.length;
        //定义一个List集合
        List<Integer> list = new ArrayList<>();
        //遍历数组
        for(int i=0;i<len;i++){
            //如果list集合中不包含当前元素
            if(!list.contains(nums[i])){
                //将当前元素添加到list集合中
                list.add(nums[i]);
            }
        }
        //遍历list集合
        for(int i=0;i<list.size();i++){
            //将list集合中的元素赋值给数组
            nums[i] = list.get(i);
        }

        //返回list集合的长度
        return list.size();
    }
    //双指针解法
   public static int removeDuplicates2(int[] nums) {
        //如果数组为空，则返回0
        if(nums==null){
            return 0;
        }
        //定义两个指针，i指向下一个不重复的元素，j指向当前元素
        int len = nums.length;
        int i=1;
        for(int j=1;j<len;j++){
            //如果当前元素不等于前一个元素，则将当前元素赋值给i指向的位置，i自增
            if(nums[j]!=nums[i-1]){
                nums[i] = nums[j];
                i++;
            }
        }
        //返回i的值，即不重复元素的数量
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = Day4_removeDuplicates.removeDuplicates2(a);

        System.out.println(i);
    }


    class Solution {
        public int removeDuplicates(int[] nums) {
            // 数组的长度
            int n = nums.length;
            // 如果数组为空，则返回0
            if (n == 0) {
                return 0;
            }
            // 快慢指针，初始值都为1
            int fast = 1, slow = 1;
            // 当快指针小于数组长度时，循环
            while (fast < n) {
                // 如果快指针指向的元素不等于前一个元素
                if (nums[fast] != nums[fast - 1]) {
                    // 将快指针指向的元素赋值给慢指针指向的元素
                    nums[slow] = nums[fast];
                    // 慢指针加1
                    ++slow;
                }
                // 快指针加1
                ++fast;
            }
            // 返回慢指针的值
            return slow;
        }
    }
}

