/**
 * 题目：1185. 一周中的第几天
 * 时间：1-3
 * 算法：
 * 1.基姆拉尔森计算公式
 * 0-星期日，1-星期一，2-星期二，3-星期三，4-星期四，5-星期五，6-星期六
 * week = ( day + 2 * month + 3 * ( month + 1 ) / 5 + year + year / 4 - year / 100 + year / 400 ) % 7 ;
 * 注意：公式中把一月和二月看成是上一年的十三月和十四月，例：如果是2004-1-10则换算成：2003-13-10来代入公式计算。
 *
 */



import java.util.Calendar;
class DayOfTheWeek {
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        public String dayOfTheWeek(int day, int month, int year) {
            //调用Calendar的api，获取日历
            Calendar calendar = Calendar.getInstance();
            //自定义日历时间的（年，月，日）
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month-1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            //调用DAY_OF_WEEK方法直接返回时间是一周的那一天
            return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
