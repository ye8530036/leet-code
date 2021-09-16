/**
 * 计数质数
 * 9-16
 * 统计所有小于非负整数 n 的质数的数量。
 * 思路：暴力求解（超时）
 */

class CountPrimes {
    public int countPrimes(int n) {
        if(n==1 || n==0)
            return 0;
        int count=0;
        for (int i=2;i<=n;i++){
            count += zhishu(i)? 1 : 0;
            }
        return count;
        }
    public boolean zhishu(int n){
        for (int i=2;i*i<n;i++){
            if (n%i==0){
                return false;
            }
    }
        return true;
    }
}
