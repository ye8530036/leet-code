/**
 * 题目：504. 七进制数
 * 时间：2022-3-7
 * 思路：直接调用Java的自带借口
 *
 */



class ConvertToBase7_504 {
    public String convertToBase7(int num) {
        //（1）直接调用借口，转换7进制
      //  return Integer.toString(num,7);
        StringBuilder sb = new StringBuilder();
        if (num<0){
            return '-'+convertToBase7(-num);
        }
        if (num==0){
            return "0";
        }
       while (num!=0){
            sb.append(num%7);
            num /=7;
        }
        return sb.reverse().toString();
    }
}
