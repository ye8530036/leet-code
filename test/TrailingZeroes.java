import java.math.BigInteger;

/**
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 算法1:暴力计算（需要考虑数过大溢出）
 * 思路:先将阶乘算出，再循环取余数直到余数不为0停止，统计循环次数即为0的数量
 *
 * 算法2:计算因子5
 * 思路:数末尾的零是怎么来的，2*5，那么5的倍数可以拆成一个因数乘5，而偶数都含有因数2，2的个数远大于5，那么所有的拆出来的因数5个数就是阶乘最后零的个数。
 * 比如44：
 * 44/5 = 8;说明1-44含有8个5的倍数，含有8个5的因子，故阶乘结尾有8个零。
 * 特殊的比如5的倍数25：
 * 25/5 = 5;说明1-25含有5个5的倍数，含有5个5的因子，但自己本身的另一个因子也是5，那么总共有6个5的因子，所以阶乘结尾有6个0。
 * 所以只要对n进行含5的因子的统计即可。
 **/
class TrailingZeroes {
    int count=0;
    public int trailingZeroes(int n) {
       while (n>0) {
           count = count + n/5;
           n=n/5;
       }
       return count;
    }
    public int ttrailingZeroes2(int n){
        BigInteger sum = BigInteger.ZERO;
        int count=0;
        for(int i=1;i<=n;i++){
            sum =sum.multiply(BigInteger.valueOf(i));
        }
        while (sum.remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count ++;
            sum=sum.divide(BigInteger.TEN);
        }
        return count;
    }
}
