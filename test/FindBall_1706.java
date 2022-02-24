/**
 * 题目：滚球——1706
 * 时间：2-24
 *
 */


class FindBall_1706 {
    public int[] findBall(int[][] grid) {
        //初始化行数
        int n = grid[0].length;
        //定义出口
        int[] ans =new int[n];
        for (int j=0;j<n;j++){
            int col = j;
            for (int[] row : grid){
                int dir = row[col];
                //dir为-1或者1,1向右移动，-1向左移动
                //col为每个球的定位值
                col += dir;
                //当col<0时小球被挡住了
                //或者col=n时是正好被挡在右边界
                //亦或者是1，-1构成V球被卡中间了
                if (col < 0 || col == n || row[col] != dir){
                    col = -1;
                    break;
                }
            }
            //将每个球的定点位置存入数组
            ans[j]=col;
        }
        return ans;
    }
}
