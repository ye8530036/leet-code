/**
 * Excel表列名称
 * 9-10
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * 算法:十进制转26进制
 * 思路：假设 A == 0，B == 1，那么 AB = 26 * 0 + 1 * 1，而现在 AB = 26 * (0 + 1) + 1 * (1 + 1)
 * 等于减一之后进行正常的25进制转换
 *
 **/
class ConvertToTitle {
    public String convertToTitle(int cn) {
        StringBuffer nb = new StringBuffer();
        while (cn >0){
            cn --;
            nb.append((char) (cn%26+'A'));
            cn/=26;
        }
        //反转值
        nb.reverse();
        return nb.toString();
    }
}
