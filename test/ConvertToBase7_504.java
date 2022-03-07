/**
 * 题目：504. 七进制数
 * 时间：2022-3-7
 * 思路：直接调用Java的自带借口
 *
 */



class ConvertToBase7_504 {
    public String convertToBase7(int num) {
        //转换成7进制
        return Integer.toString(num,7);
    }
}
