/**
 * 题目：1446. 连续字符
 * 时间：12-1
 * 算法：一次遍历
 *
 */




class Max_Power  {
    public int maxPower(String s) {
        int ans = 1 ,cnt = 1;
        //遍历字符串
        for (int i=1;i<s.length();++i){
            //如果是连续相同的字符
            if (s.charAt(i)==s.charAt(i-1)){
                //计数器统计数量
                cnt++;
                //将计数器的数字赋值给ans
                ans = Math.max(ans,cnt);
            }
            else cnt=1;
        }
        return ans;
    }
}
