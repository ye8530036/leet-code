/**
 * 各位相加
 *
 * 10.13
 *
 * 递归
 *
 *
 */

class AddDigits {
    public int addDigits(int num) {
       if (num<10){
           return num;
       }
       int next=0;
       while (num!=0){
           next = next + num%10;
           num  = num/10;
       }
       return addDigits(next);
    }
}
