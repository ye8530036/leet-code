/**
 * 位1的个数
 * 9-13
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * 解法1：暴力破解
 * 将输入的32位整形字符转换成字符串
 * 再循环比对是否为1，统计1的数量
 * 解法2：位运算
 * 统计与运算次数，即为统计1的个数
 */
class HammingWeight {
    public int hammingWeight01(int n){
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i=0 ;i<str.length();i++){
            if (str.charAt(i)=='1')
                count ++;
        }
        return count;
    }
    public int hammingWeight02(int n){
        int count=0;
        while (n != 0){
            //n & (n−1)，其运算结果恰为把n的二进制位中的最低位的1变为0之后的结果
            n &= n - 1;
            count++;
        }
        return count;
    }
}
