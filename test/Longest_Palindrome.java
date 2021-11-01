/**
 * 时间：10.31
 * 难度：中等
 * 题目:最长回文子串
 * 动态规划：
 * 我们用一个 boolean dp[j][i] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[j][i]=true，
 * 我们要判断 dp[j-1][i+1] 是否为回文。只需要判断字符串在(j-1)和（i+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
 * 初始状态，j=i 时，此时 dp[j][i]=true。
 * 状态转移方程，dp[j][i]=true 并且(j-1)和（i+1)两个位置为相同的字符，此时 dp[j-1][i+1]=true。
 *
 */



class Longest_Palindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        int strLen = s.length();
        //最长回文串的起点
        int maxStart = 0;
        //最长回文串的终点
        int maxEnd = 0;
        //最长回文串的长度
        int maxLen =1;
        boolean [][] dp = new boolean[strLen][strLen];
        //
        for (int i=1;i<strLen;i++){
            for (int j=0;j<i;j++){
                //判定是回文子串的条件
                if (s.charAt(j)==s.charAt(i)&&(i-j<=2 || dp[j+1][i-1]))
                {
                    //dp[j][i]是回文
                    dp[j][i]=true;
                    if (i-j+1>maxLen){
                        maxLen = i-j+1;
                        maxStart =j;
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}
