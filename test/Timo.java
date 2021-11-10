/**
 * 题目：提莫攻击（495）
 * 时间：11-10
 * 算法：暴力破解
 */



class Timo {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        if (timeSeries.length==1){
            return duration;
        }
        for (int i=0;i<timeSeries.length-1;i++){
            //添加中毒时间，如攻击间隔小于中毒的持续时间则会持续中毒加攻击间隔时间，反之则加中毒持续时间
            ans += Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        //统计总中毒时间
        return ans+duration;
    }
}
