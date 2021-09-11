/**
 * Excel表列名称
 * 9-10
 * A <- 1
 * B <- 2
 * C <- 3
 * ...
 * Z <- 26
 * AA <- 27
 * AB <- 28
 * 算法:十进制转26进制
 * 思路：假设 A == 0，B == 1，那么 AB = 26 * 0 + 1 * 1，而现在 AB = 26 * (0 + 1) + 1 * (1 + 1)
 * 等于减一之后进行正常的25进制转换
 * 反向转换详情参照CovertToTitle
 **/

class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        //将字符串放入数组，方便计算每一个字符
        char[] Array = columnTitle.toCharArray();
        //设定初始值
        int num = 0;
        for (int i=0;i<columnTitle.length();i++){
            //转换回来需要加1
            num = num*26 +(Array[i]-'A'+1);
        }
        return num;
    }
}
