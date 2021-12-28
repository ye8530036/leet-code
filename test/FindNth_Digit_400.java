/**
 * 题目：400.第 N 位数字
 * 时间：11-30
 * 算法：找规律
 * 一位数总共有 9 个整数，共 9 个数字；
 * 两位数总共有 90 个整数，共 90 * 2 个数字；
 * 三位数总共有 900 个整数，共 900 * 3 个数字；
 * 我们求的n要先确定它的位数，其次再确定它的数字，最后用处理好的n来得出个位数字
 */


class FindNth_Digit_400 {
    public int findNthDigit(int n) {
        //num表示具体整数
        int num = 1;
        // count表示几位数
        int count = 1;
        while (n>9 *(long) num *count){
            //处理n得到相应位数后对应的n
            n -= 9 * num *count;
            num *= 10;
            //得到相应的位数
            count++;
        }
        //确定具体是什么数字
        num +=(n-1)/count;
        //确定是该数字的哪一位
        n -= (n-1)/count*count;
        //得到该位的数字
        return (num/(int)Math.pow(10,count-n)) %10;
    }
}
