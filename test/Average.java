/**
 * 题目：1491. 去掉最低工资和最高工资后的工资平均值
 * 时间：11-27
 * 解法：暴力
 *
 */




class Average {
    public double average(int[] salary){
        double sum = 0;
        //Integer.MIN_VALUE = -2147483648 Integer.MIN_VALUE = 2147483647
        double max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
        for (int num :salary){
            sum += num;
            //找出salary中的最大值和最小值
            max_num =Math.max(max_num, num);
            min_num =Math.min(min_num, num);
        }
        return (sum - max_num - min_num) /(salary.length - 2);
    }
}
