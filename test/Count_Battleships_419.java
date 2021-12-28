/**
 * 题目：419. 甲板上的舰队
 * 时间：12-18
 * 思路及理解：首先双循环遍历矩阵，找出K战舰的点
 * 由于舰队之间至少有一个水平或垂直的空位分隔，即没有相邻的战舰
 * 故我们只需要统计战舰的左上点为空值的点即可统计出舰队的数量
 * 即当遇到board[i][j]=='X'时，分别检查左侧和上方的位置是否也是'X'：
 * 如果是，则不是一艘新舰队；
 * 否则，增加一艘新舰队；
 */

class Count_Battleships_419 {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i=0;i<row;++i){
            for (int j=0;j<col;++j){
                //找到起点，之后比对该舰队的左上和左有无战舰
                if (board[i][j]=='X'){
                    if (i>0 && board[i-1][j]=='X'){
                        continue;
                    }
                    if (j>0 && board[i][j-1]=='X'){
                        continue;
                    }
                    //左点和左上点都为空，舰队数量加一
                    ans++;
                }
            }
        }
       return ans;
    }
}
