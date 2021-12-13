/**
 * 题目：807. 保持城市天际线
 * 时间：12-13
 * 思路：该题的天际线不改变前提下求得最大高度增量总和，即不改变每一行每一列的高度最大值
 * 因此我们可以用贪心算法来计算建筑的最大高度增量总和；
 */



class Max_Increase_Keeping_Skyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n= grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        //扫描行
        for (int i=0;i<n;i++){
            //扫描列
            for (int j=0;j<n;j++){
                //分别得到行和列的最大值
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int ans=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                //为了保持城市天际线，该建筑物增加后的高度不能超过其所在行和所在列的建筑物高度最大值
                //故该建筑物增加后的最大高度是 min(rowMax[i],colMax[j]）
                //该建筑物的原始高度是grid[i][j]
                //因此该建筑物高度可以增加的最大值是 min(rowMax[i],colMax[j])−grid[i][j]
                ans += Math.min(rowMax[i],colMax[j])- grid[i][j];
            }
        }
        return ans;
    }
}
