/**
 * 题目：有效的完全平方数
 * 思路：二分法
 * 算法：运用二分法寻找平方数；
 * 减少循环的次数
 */


public class Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int left=0,right = num;
        while (left<=right){
            int mid = (right-left)/2+left;
            long square = (long) mid*mid;
            if (square<num){
                left=mid+1;
            }
            else if (square>num) {
                right=mid-1;
            }
            else return true;
        }
        return false;
    }
}
