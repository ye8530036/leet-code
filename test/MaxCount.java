/**
 * 题目：范围求和II（598）
 * 时间 ：11-7
 * 思路：等于是找最小重合范围，首先他给了3个范围，我们找到最小的长和宽
 * 将最小的长和宽相乘，即能得出最小范围，得出题解；
 *
 */



class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        int max = m,min=n;
        for (int[] op:ops){
            max = Math.min(max,op[0]);
            min = Math.min(min,op[1]);
        }
        return max*min;
    }
}
