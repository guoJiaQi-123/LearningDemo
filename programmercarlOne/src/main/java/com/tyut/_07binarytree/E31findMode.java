package com.tyut._07binarytree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @author OldGj 2024/6/14
 * @apiNote 501. 二叉搜索树中的众数
 */
public class E31findMode {
    // 自己写的
    List<Integer> list = new ArrayList<>();
    TreeNode prev = new TreeNode(Integer.MAX_VALUE);
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        rec(root);
        Optional<Integer> max = map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .max(Integer::compareTo);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max.get()) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void rec(TreeNode root) {
        if (root == null) {
            return;
        }
        rec(root.left);
        if (prev.val == root.val) {
            map.put(root.val, map.get(root.val) + 1);

        } else {
            map.put(root.val, 1);
        }
        prev = root;
        rec(root.right);

    }

    /**
     * 暴力，同样可以解决非二叉搜索树求众数问题
     * 需要对树进行一次遍历，
     * 对map集合进行两次遍历，第一次遍历确定出现频率最高的节点，第二次遍历确定是否存在其他相同频率的节点【可优化为一次】
     */
    static class Solution {
        public int[] findMode(TreeNode root) {
            // 定义一个map用于记录每个节点出现的频率
            Map<Integer, Integer> map = new HashMap<>();
            // 存放结果集合
            List<Integer> list = new ArrayList<>();
            // 如果root为null，直接返回
            if (root == null) {
                return list.stream().mapToInt(Integer::intValue).toArray();
            }
            // 获得频率 Map
            searchBST(root, map);
            // 执行完上述递归代码，此时的map中的key存放着节点值，value存放着节点出现的频率
            List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                    // 将map根据节点出现的频率进行降序排序，出现次数最多的在最前面
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .collect(Collectors.toList());
            // 将出现次数最多的节点的值加入结果集合中
            list.add(mapList.get(0).getKey());
            // 再次遍历map集合，将其余出现次数一样多的节点加入结果集合【因为题目描述重视不止一个节点】
            for (int i = 1; i < mapList.size(); i++) {
                // 如果map中的其余节点和第一个节点出现的频率相同，则全部加入到结果集合
                // 因为已经拍过序了，所以第一个节点一定是出现频率最高的节点
                if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                    list.add(mapList.get(i).getKey());
                } else {
                    // 一旦不相等了直接退出循环即可，后面的出现频率只会更少
                    break;
                }
            }
            // 将Integer类型的List集合转换为int类型数组返回
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        /*
            前序遍历每个节点，获取每个节点出现的次数map的结构<节点值，节点出现的次数>
         */
        void searchBST(TreeNode curr, Map<Integer, Integer> map) {
            if (curr == null) {
                return;
            }
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            searchBST(curr.left, map);
            searchBST(curr.right, map);
        }
    }

    /**
     *  优化，只需要遍历一次二叉搜索树
     */
    static class Solution2 {
        ArrayList<Integer> resList;
        int maxCount;
        int count;
        TreeNode pre;

        public int[] findMode(TreeNode root) {
            // 初始化全局变量
            resList = new ArrayList<>();
            maxCount = 0;
            count = 0;
            pre = null;
            doFindMode(root);
            return resList.stream().mapToInt(Integer::intValue).toArray();
        }

        public void doFindMode(TreeNode root) {
            if (root == null) {
                return;
            }
            doFindMode(root.left);
            // 中序遍历
            int rootValue = root.val;
            // 【前提：二叉搜索树中序遍历是有序的】
            // 计数 如果pre为null，说明遍历到的是第一个节点，或者rootValue!=pre.val说明遍历到了一个新的值的节点
            if (pre == null || rootValue != pre.val) {
                // 每个新的值的节点都是从count为1开始++的
                count = 1;
            } else {
                count++;
            }
            // 更新结果以及maxCount
            if (count > maxCount) { // 如果count值大于了maxCount，说明发现了一个新的频率出现最多的节点
                // 将原先保存的出现频率为maxCount的节点全部删除，加入更多频率的节点
                resList.clear();
                resList.add(rootValue);
                // 更新maxCount的值
                maxCount = count;
            } else if (count == maxCount) {
                // 如果当前节点出现频率已经等于最大频率，加入结果集合
                resList.add(rootValue);
            }
            // 记录当前节点，下次递归即为前一个节点
            pre = root;
            doFindMode(root.right);
        }
    }

    /**
     * 迭代法，思路与递归完全一样，只是中序遍历的代码换成了迭代
     */
    static class Solution3 {
        public int[] findMode(TreeNode root) {
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            int maxCount = 0;
            int count = 0;
            TreeNode cur = root;
            // 中序遍历
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    // 计数
                    if (pre == null || cur.val != pre.val) {
                        count = 1;
                    } else {
                        count++;
                    }
                    // 更新结果
                    if (count > maxCount) {
                        maxCount = count;
                        result.clear();
                        result.add(cur.val);
                    } else if (count == maxCount) {
                        result.add(cur.val);
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
