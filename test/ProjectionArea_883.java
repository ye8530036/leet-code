/**
 * 时间：11-9
 * 题目：三维形体投影面积（883）
 * 思路：双循环来遍历数组，再将数组的最大值进行统计即得出各个面的阴影数量，将阴影数量相加进行统计即为解；
 */
class ProjectionArea_883 {
    public int projectionArea(int[][] grid) {
        //统计所有方块数量
        int N = grid.length;
        int ans = 0;

        for (int i=0;i<N;++i){
            //清空数据
            int bestA = 0;
            int bestB = 0;
            for (int j=0;j<N;++j){
                //统计顶部阴影数量
                if (grid[i][j]>0) ans++;
                //统计侧面的阴影数量
                bestA = Math.max(bestA,grid[i][j]);
                //统计侧面的阴影数量
                bestB = Math.max(bestB,grid[j][i]);
            }
            //将所有阴影数量结合
            ans += bestA + bestB;
        }
        return ans;
    }
}
