package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/15
 * @apiNote 51. N 皇后
 */
public class E13solveNQueens {

    /*
        解决N皇后问题需要定义三个boolean类型的数组分别表示当前列是否存在冲突，当前左斜线是否存在冲突和当前右斜线是否存在冲突
        数组定义如下：
        currCol => 当前列
        leftSlash => 左斜线
        rightSlash => 右斜线
     */

    boolean[] currCol; // 列冲突
    boolean[] leftSlash; // 左斜线冲突
    boolean[] rightSlash; // 右斜线冲突
    char[][] chessBoard; // 棋盘
    List<List<String>> res = new ArrayList<>(); // 所有结果
    List<String> path = new ArrayList<>(); // 一种结果

    public List<List<String>> solveNQueens(int n) {
        currCol = new boolean[n]; // 当前列数组大小和N皇后的N的大小相同
        leftSlash = new boolean[2 * n - 1]; // 左斜线的大小等于2*N-1，因为在N*N大小的棋盘上有2*N-1个对角线
        rightSlash = new boolean[2 * n - 1]; // 右斜线同理
        chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        // 参数一：当前行，参数二：棋盘大小
        dfs(0, n);
        return res;
    }


    private void dfs(int i, int n) {
        // 递归终止条件
        if (i == n) { // 当行数等于棋盘大小时，说明所有行的皇后已经全部放了，拼装结果返回
            for (char[] chars : chessBoard) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : chars) {
                    stringBuilder.append(c);
                }
                path.add(stringBuilder.toString());
            }
            res.add(new ArrayList<>(path));
            path.clear();
        }
        for (int j = 0; j < n; j++) { // j循环的是列
            // 如果发生冲突，则跳过该列
            if (currCol[j] || leftSlash[i + j] || rightSlash[n - 1 - (i - j)]) {
                continue;
            }
            chessBoard[i][j] = 'Q'; // 放皇后
            currCol[j] = leftSlash[i + j] = rightSlash[n - 1 - (i - j)] = true; // 记录冲突
            dfs(i + 1, n); // 往下一行放皇后
            chessBoard[i][j] = '.';  // 回溯撤销皇后
            currCol[j] = leftSlash[i + j] = rightSlash[n - 1 - (i - j)] = false; // 回溯撤销冲突
        }
    }
}
