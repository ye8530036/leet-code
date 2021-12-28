/**
 * 题目：1034. 边界着色
 * 时间：12-7
 * 思路：从题目给定的 (row, col) 进行出发，如果遍历到「连通分量的边界」格子，则使用 color 进行上色。
 * 同一「连通分量」的「非边界」格子满足：
 * 当前格子的四联通方向均存在相邻格子，且当前格子与四联通相邻格子颜色一致。
 * 也就是说，我们从 (row, col) 进行出发，遍历 (row, col) 所在的「连通分量」，
 * 如果遍历到的「连通分量」格子不满足上述条件（边界格子），则进行上色
 *
 *
 */




import java.util.ArrayDeque;
import java.util.Deque;

class Color_Border_1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length,n = grid[0].length;
        //ans作为判重数组使用（通过判断 ans[i][j] 是否为 0 来得知是否被处理）
        int [][] ans = new int[m][n];
        //定义四个方向
        int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> d = new ArrayDeque<>();
        //将row与col进行入列
        d.addLast(new int[]{row,col});
        //BFS主体当d不为空时即存在连通分量及连通边界
        while (!d.isEmpty()){
            int [] poll = d.pollFirst();
            int x =poll[0],y = poll[1],cnt =0;
            //每次从队列中取出元素进行「四联通拓展」
            for (int[] di:dirs){
                int nx = x+di[0],ny = y+di[1];
                if (nx<0 || nx >=m || ny<0 ||ny>=n){
                    continue;
                }
                //判定颜色是否相同
                if (grid[x][y] !=grid[nx][ny]){
                    continue;
                }
                else {
                    //记录联通个数
                    cnt++;
                }
                if (ans[nx][ny] !=0){
                    continue;
                }
                d.addLast(new int[]{nx,ny});
            }
            //记录当前出队是否为边界格子。若为边界格子，则使用 color 进行上色；
            ans[x][y] = cnt ==4 ?grid[x][y] :color;
        }
        //对ans遍历将未上色（ans[i][j] = 0）的位置使用原始色（grid[i][j]）进行上色。
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (ans[i][j]==0){
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }
}
