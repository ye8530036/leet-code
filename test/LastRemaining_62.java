/**
 * 题目：约瑟夫环问题——剑指 Offer 62. 圆圈中最后剩下的数字
 * 时间：2022.2.22
 * 算法公式：(当前index + m) % 上一轮剩余数字的个数
 */

class LastRemaining_62 {
    public int lastRemaining(int n, int m) {
        int ans=0;
        //从最后开始反推最后仅剩下2个，所以从两个数开始向上加
        for (int i=2;i<=n;i++){
            ans = (ans+m)%i;
        }
        return ans;
    }
}
