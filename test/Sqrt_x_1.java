/**
 * x的平方根
 * 7-16
 * 二分法
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 */
class Sqrt_x_1 {
    public int mySqrt(int x) {
        int left=0 ,right=x,ans=-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if ((long)mid*mid <=x){
                ans = mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }
}
