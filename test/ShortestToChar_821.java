import java.util.Arrays;

/**
 * 题目：821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数
 * 时间：2022-4-19
 */
class ShortestToChar_821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int [] ans = new int[n];
        Arrays.fill(ans,n+1);
        //第一次遍历从前往后遍历将距离添加进数组
        for (int i=0,j=-1;i<n;i++){
            if (s.charAt(i)==c){
                j=i;
            }
            if (j!=-1){
                ans[i] = i-j;
            }
        }
        //第二次从后向前遍历，再比对距离
        for (int i=n-1,j=-1;i>=0;i--){
            if (s.charAt(i)==c){
                j=i;
            }
            if (j!=-1){
                //看是左边的离得近还是右边的近
                ans[i] = Math.min(ans[i],j-i);
            }
        }
        return ans;
    }
}
