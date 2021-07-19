/**
 * 爬楼梯
 * 7-19
 * 递归，动态规划
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */

class climb_stairs_1 {
    public int climbStairs(int n) {
        int [] all = new int[n+1];//初始化栈
        all[0]=1;
        all[1]=1;
        for (int i=2;i<=n;i++){
            all[i]=all[i-1]+all[i-2];
        }
        return all[n];
    }
}
/**
 * 爬楼梯
 * 7-19
 * 斐波那契数列
 *
 * 公式：F(n)=1/sqrt(5)[(1+sqrt(5))ⁿ-(1-sqrt(5))ⁿ]
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */
class climb_stairs_2 {
    public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);//栈从0开始，故n+1
        return (int)(fib_n / sqrt_5);
    }
}