package com.feishu._07backtracking;

import com.sun.source.tree.NewArrayTree;

/**
 * @version v1.0
 * @author OldGj 2024/9/15
 * @apiNote 37. 解数独
 */
public class E14solveSudoku {

    /*
        解数独问题的核心仍然是记录冲突状态
        ca 行冲突
        cb 列冲突
        cc 九宫格冲突
        每个冲突都需要一个二维boolean类型的数组记录
        ca[0][0] = true 表示第0行存在数字1
        ca[0][1] = true 表示第0行存在数字2
        cb[2][8] = true 表示第2列存在数字9
        以此类推
     */
    boolean[][] ca = new boolean[9][9]; // 行冲突
    boolean[][] cb = new boolean[9][9];// 列冲突
    boolean[][] cc = new boolean[9][9];// 九宫格冲突

    public void solveSudoku(char[][] board) {
        // 记录当前数独中已经存在的数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') { // 如果字符不为'.'
                    ca[i][c - '1'] = true; // 将其所在行的数字c设置为冲突(该行不能再添加c数字)
                    cb[j][c - '1'] = true; // 将其所在列的数字c设置为冲突(该列不能再添加c数字)
                    cc[i / 3 * 3 + j / 3][c - '1'] = true;  // 将其所在九宫格的数字c设置为冲突(该九宫格不能再添加c数字)
                }
            }
        }
        // 参数一：正在处理的行，参数二：正在处理的列，参数三：整个二维数组
        dfs(0, 0, board);
    }

    private boolean dfs(int i, int j, char[][] board) {
        // 跳过数独中已经有数字的地方
        while (board[i][j] != '.') {
            // 超出列长，则列长恢复为0，行++
            if (++j >= 9) {
                j = 0;
                i++;
            }
            // i>=9 说明已经遍历完所有数组中的元素
            if (i >= 9) {
                return true;
            }
        }
        // 通过上面的while跳过数独中有数字的地方，找到了没有数字的地方，开始尝试从1~9放入数字
        for (int x = 1; x <= 9; x++) {
            // 如果添加的数字x在当前行，当前列，当前九宫格中有任意一个冲突，则跳过，尝试下一个数字
            if (ca[i][x - 1] || cb[j][x - 1] || cc[i / 3 * 3 + j / 3][x - 1]) {
                continue;
            }
            // 如果没有冲突，向[i,j]节点添加x数字
            board[i][j] = (char) (x + '0');
            // 添加完数字后，更新冲突数组，把当前行，当前列，当前九宫格中的x-1设置为true
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = true;
            boolean dfs = dfs(i, j, board); // 递归
            if (dfs) {
                return true; // 如果找到解，则直接返回true
            }
            board[i][j] = '.'; // 如果没找到解，回溯
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = false; //回溯
        }
        return false;
    }
}
