/**
 *  一和零
 * 9-23
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
 * 思路：动态规划（暴力破解）
 * 物品一个一个尝试，容量一点一点尝试，物品只有选与不选两个选项。
 * 最后找到状态转移方程
 */
class Zero_One_knapsack {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp =new int[m+1][n+1];
        int onenum,zeronum;
        for (String str:strs){
            onenum = 0;
            zeronum= 0;
            for (char c:str.toCharArray()){
                if (c =='0'){
                    zeronum++;
                }
                else {
                    onenum++;
                }
            }
            for (int i=m;i>=zeronum;i--)
                for (int j=n;j>=onenum;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeronum][j-onenum]+1);
                }
        }
        return dp[m][n];
    }
}
