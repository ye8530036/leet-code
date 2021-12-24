/**
 * 题目：1705. 吃苹果的最大数目
 * 时间：11-24
 * 算法：优先队列+贪心
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        //创建优先队列
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = apples.length,time = 0,ans =0;
        //首先，如果「time<n」或者「堆不为空」，说明「还有苹果未被生成」或者「未必吃掉」，继续模拟；
        while (time<n ||!q.isEmpty()){
            //在当日模拟中「time<n」，说明当天有苹果生成
            if (time<n &&apples[time]>0){
                //先将苹果 以二元组(time+days[time]−1,apples[time]) 形式加入小根堆中
                //其中二元组表示 (最后食用日期, 当日产生苹果数量)，同时需要过滤 apples[time] = 0 的情况。
                q.add(new int[]{time+days[time]-1,apples[time]});
            }
            //如果保质期小于时间，利用出列将坏掉的苹果丢掉
            while (!q.isEmpty() && q.peek()[0]<time){
                //坏掉的苹果出列
                q.poll();
            }
            //如果堆不为空
            if (!q.isEmpty()){
                //然后尝试从堆中取出「最后食用日期」最早「可食用」的苹果 cur，如果堆顶元素已过期，则抛弃；
                int[] cur = q.poll();
                //如果吃掉 cur 一个苹果后，仍有剩余，并且最后时间大于当前时间（尚未过期），将 cur 重新入堆；
                if (--cur[1]>0 &&cur[0]>time){
                    q.add(cur);
                }
                //增加吃苹果数
                ans++;
            }
            time++;
        }
        return ans;
    }
}
