/**
 * 题目：762. 二进制表示中质数个计算置位
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 * 解析：从低到高的第 i 位为 1 表示 i 是质数，为 0 表示 i 不是质数。
 * 设整数 x 的二进制中 1 的个数为 c，若 mask 按位与 2 不为0，则说明c是一个质数。
 * 时间：2022-4-5
 *
 */



class CountPrime_SetBits_762 {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x=left;x<right;x++){
            //665772=(1010,0010,1000,1010,1100)
            //num >> 1,相当于num除以2
            //&按位与的运算规则是将两边的数转换为二进制位，然后运算最终值
            //运算规则即(两个为真才为真)
            //1&1=1 , 1&0=0 , 0&1=0 , 0&0=0
            if (((Integer.bitCount(x)>>1) & 665772)!=0){
                ++ans;
            }
        }
        return ans;
    }
}
