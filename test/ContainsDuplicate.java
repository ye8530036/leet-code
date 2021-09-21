import java.util.Arrays;
/**
 * 存在重复元素
 * 9-21
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 思路：循环比对
 * 先将数组元素进行排序，再将数组中元素两两比对，如果有重复的则返回true，否则返回false。
 */

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //给数组排序
        Arrays.sort(nums);
        int n =nums.length;
        for (int i=0;i<n-1;i++) {
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
