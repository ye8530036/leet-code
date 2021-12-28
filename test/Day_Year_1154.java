/**
 * 题目：1154. 一年中的第几天
 * 时间：12-21
 * 算法：直接计算；也可调用封装的接口来实现
 * 直接计算的思路是首先截取字符串的年月日的部分
 * 再将之年的部分计算是否是闰年，由于每一年的日期固定，我们均需要考虑闰年的二月即可
 * 最后利用循环累加每月的天数
 */





//import java.time.LocalDate;

class Day_Year_1154 {
    public int dayOfYear(String date) {
        //直接调用接口
       // return LocalDate.parse(date).getDayOfYear();
        //初始化天数
        int ans = 0;
        //统计年
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        //将每个月的天数列出
        int[] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        //计算是否是闰年
        if (year%400==0 || (year%4==0 && year%100!=0)){
            months[1]=29;
        }
        //循环加上每个月的天数
        for (int i=0;i<month-1;i++) {
            ans+=months[i];
        }
        return ans+day;
    }
}
