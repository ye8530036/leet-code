/**
 * 题目：猜数字大小II(375)
 * 时间：11-12
 * 算法：动态规划
 * 将大问题不断的分解成小问题解决
 *
 */


class GetMoneyAmount {
    public int getmoneyamount(int n){
        int[][] dp = new int[n+2][n+2];
        for (int len =2;len<=n;len++){
            for (int i = 1;i<=n-len+1;i++){
                int j = i+len-1;
                int min = Integer.MAX_VALUE;
                for (int k = i;k<=j;k++){
                    min = Math.min(min,Math.max(dp[i][k-1],dp[k+1][j])+k);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
