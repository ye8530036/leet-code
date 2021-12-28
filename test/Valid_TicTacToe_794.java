/**
 * 题目：794. 有效的井字游戏
 * 时间：12-9
 * 思路：首先记录下X与O的数量，并记录
 * 再按照条件一一比对非法与合法的条件
 */



class Valid_TicTacToe_794 {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0,oCount = 0;
        for (String row:board){
            //统计X与O的个数
            for (char c :row.toCharArray()){
                xCount = (c =='X') ? (xCount +1) : xCount;
                oCount = (c =='O') ? (oCount +1) : oCount;
            }
        }
        //如果不满足 xCount≥oCount，则此时为非法，直接返回 false
        if (oCount != xCount && oCount != xCount -1){
            return false;
        }
        //首先检查玩家一是否获胜，获胜的话对比oCount+1与xCount是否相等，若不等即为非法
        if (win(board,'X') && oCount != xCount-1){
            return false;
        }
        //首先检查玩家二是否获胜，获胜的话对比oCount与xCount是否相等，若不等即为非法
        if (win(board,'O') && oCount != xCount){
            return false;
        }
        return true;
    }
    //然后我们检查是否有玩家是否获胜
    //检查在棋盘的 3 行，3 列和 2 条对角线上是否有该玩家的连续 33 枚棋子
    public boolean win(String[] board,char p){
        for (int i=0;i<3;++i){
            //行
            if (p==board[0].charAt(i) && p==board[1].charAt(i) && p==board[2].charAt(i)){
                return true;
            }
            //列
            if (p==board[i].charAt(0) && p==board[i].charAt(1) && p==board[i].charAt(2)){
                return true;
            }
        }
        //两对角线
        if (p==board[0].charAt(0) && p==board[1].charAt(1) && p==board[2].charAt(2)){
            return true;
        }
        if (p==board[0].charAt(2) && p==board[1].charAt(1) && p==board[2].charAt(0)){
            return true;
        }
        return false;
    }
}
