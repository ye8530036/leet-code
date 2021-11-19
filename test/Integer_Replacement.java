/**
 * 题目：397. 整数替换
 * 时间：11-19
 * 算法：暴力（利用递归式）
 */



class Integer_Replacement {
    public int integerReplacement(int n) {
       return dfs(n);
    }
    public int dfs (long n){
        if (n==1)
            return 0;
        if (n % 2 ==0){
            return dfs(n / 2 ) + 1;
        }
        //求是+1最短还是-1
        return Math.min(dfs(n+1),dfs(n-1))+1;
    }
}
