import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 *
 * 10.11
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 算法：回溯算法（回溯一般位于递归主体下面）
 *
 * 回溯模板：
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 *
 *
 *
 */

class Nqueen {
    List<List<String>> res = new ArrayList<>();
    //主体
    public List<List<String>> solveNQueens(int n) {
        //创建棋盘
        char[][] chessboard = new char[n][n];
        //循环填充.
        for (char[] c : chessboard){
            Arrays.fill(c,'.');
        }
        //从第0行开始单层搜索
        backTrack(n,0,chessboard);
        return res;
    }

    //单层搜索，row控制棋盘的行，col控制棋盘的列
    public void backTrack(int n,int row,char [][] chessboard){
        if (row==n){
            res.add(Array2List(chessboard));
            return;
        }
        for (int col=0;col<n;++col){
            if (isValid ( row , col , n , chessboard)){
                chessboard[row][col] = 'Q';
                //递归主题
                backTrack(n,row+1,chessboard);
                //回溯部分
                chessboard[row][col] = '.';
            }
        }

    }


    public List Array2List(char[][] chessboard){
        List<String> list = new ArrayList<>();

        for(char[] c:chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    //验证棋盘是否符合规则
    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
