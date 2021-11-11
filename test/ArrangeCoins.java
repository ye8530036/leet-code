/**
 * 题目:排列硬币（441）
 * 时间：11-11
 * 解法：暴力
 * 注意点：
 * 因为n满足1<=n<=2^{31}-1
 * 因此总行数一定不超过 2(sqrt{n}+1)
 *
 */


class ArrangeCoins {
    public int arrangeCoins(int n) {
        if (n <= 2){
            return 1;
        }
        double val = 2*(Math.sqrt(n) + 1);
        long  ans = 0;
        for (int i=1;i<=n;i++){
            ans += i;
            if (ans > n){
                return i-1;
            }else if (ans == n){
                return i;
            }
        }
        return 0;
    }


}
