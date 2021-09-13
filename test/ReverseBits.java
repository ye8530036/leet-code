/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 这个方法的作用是用来将int类型变量的二进制表示进行按位反转
 * >>>= 意思为：无符号右移就是将那个数转为2进制然后在前面补0
 * <<= 意思为：左移后赋值
 * https://www.cnblogs.com/SunArmy/p/9837348.html(位运算符参考)
 **/

class ReverseBits {
    public int reverseBits01(int n) {
        return Integer.reverse(n);
    }
    public int reverseBits02(int n) {
        int result = 0;
        for (int i=0;i<32;i++){
            result<<=1;
            result |= n & 1;
            n >>>= 1;
        }
        return result;
    }
}
