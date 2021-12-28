/**
 * 题目:灯泡开关（319）
 * 时间：11-15
 * 思路：数学方法
 * 第i个灯泡是否亮着取决于他的因数个数是否为奇数
 * 分解问题；仅在i为完全平方数时它的因数数量为奇数，所以只要开平方就行
 */



class Bulb_Switch_319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
