/**
 * 买卖股票的最佳时机II
 * ８-10
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 算法:贪心算法
 *
 * 思路及算法:
 *
 * 只比较前后两天涨跌，只在地点买入，高点卖出
 * (等于开了上帝视角，穿越到明后天得知当天的股票价位再穿越回当天决定是否卖出还是买入)
 */



public class MaxProfit_II {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<=1)
        {
            return 0;
        }
        int sum = 0;
        for (int i=1;i<prices.length;i++)
        {
            if (prices[i]<prices[i+1])
            {
                sum += (prices[i+1]-prices[i]);
            }
        }
        return sum;
    }
}
