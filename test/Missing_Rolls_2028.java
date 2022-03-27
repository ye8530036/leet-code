import java.util.Arrays;

/**
 * 题目：2028. 找出缺失的观测数据
 * 现有一份 n + m次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 * 给你一个长度为 m 的整数数组 rolls ，其中rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 * k个数字的 平均值 为这些数字求和后再除以k 。
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被n + m整除。
 * 时间：2022-3-27
 */





class Missing_Rolls_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //m+n统计总长度cnt
        int m = rolls.length,cnt = m+n;
        //t是总点数
        int t = mean * cnt;
        for (int i:rolls){
            t -= i;
        }
        //查看剩余点数是否超出
        if (t<n ||t>6 * n){
            return new int[0];
        }
        //填入答案
        int [] ans = new int[n];
        Arrays.fill(ans,t/n);
        Arrays.fill(ans,0,t-t/n*n,t/n+1);
        return ans;
    }
}
