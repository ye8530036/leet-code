/**
 * 两数之和—输入有序数列
 * 9-9
 * 算法:双指针
 *
 * 给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 思路及算法:
 *
 * 初始时双指针【low，high】分别指向头和尾，每次计算两指针数的和
 * 当所算的数大于target时尾部指针向前移动一格
 * 当所算的数小于target时头部的指针向后移动一格
 * 当算出来的和恰好等于target时，记录下两指针的位置
 *
 **/
class TwoSum {
    public int[] twosum(int[] number ,int target){
        int low = 0;
        int high = number.length - 1;
        while (low<high) {
           int sum = number[low] + number[high];
           if (sum == target) {
               return new int[]{low+1,high+1};
           }
           else if (sum >target){
               high --;
           }else
               low ++;
        }
        return new int[]{-1,-1};
    }
}
