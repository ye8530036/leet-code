/**
 * 题目：440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * 时间：2022-3-23
 * 算法：构建字典树
 */

class FindKthNumber_440 {
    public int findKthNumber(int n, int k) {
        int  curr = 1;
        k--;
        while (k>0){
            // 以n为根的子树节点有steps个
            int steps = getStep(curr,n);
            // 如果个数比k少，那么这个部分都可以直接跳过
            if (steps<=k){
                // 跳过全部
                k -=steps;
                // 往右移一位
                curr++;
            }
            // 如果数量比k多，那么我们要找的结果就一定是以n下的子节点
            else {
                // 往下走一层
                curr =curr*10;
                // 跳过当前结点
                k--;
            }
        }
        return curr;
    }
    // 获得以n为根结点的子树节点数量
    public int getStep(int curr,long n){
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first<=n){
            // 一次性求出下一层的节点个数和，要是没满就用last来减，要是满了就用n减
            steps +=Math.min(last,n) - first + 1;
            first = first *10;
            last = last *10+9;
        }
        return steps;
    }
}
