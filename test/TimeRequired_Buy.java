/**
 * 题目：5926（买票需要的时间）
 * 11-14 周赛第一题
 * 一次遍历
 */

class TimeRequired_Buy {
    public int timeRequiredToBuy(int[] tickets, int k) {
       int ans=0;
       int selfcost = tickets[k];
       for (int i = 0;i<k;i++){
           if (tickets[i]<selfcost){
               ans += tickets[i];
           }
           else {
               ans += selfcost;
           }
       }
       for (int i=k+1;i<tickets.length;i++){
           if (tickets[i] < selfcost){
               ans +=tickets[i];
           }
           else {
               ans +=selfcost - 1;
           }
       }
       ans +=selfcost;
       return ans;
    }
}
