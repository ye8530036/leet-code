import java.util.Arrays;

/**
 * 时间：11.6
 * 题目：丢失的数字（268）
 * 思路：先排序再一一对比
 * 时间复杂度：
 *
 */



class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        //将数组排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n;i++){
            //一一比对下标与数组内的数
            if (nums[i] != i){
                return i;
            }
        }
        //要返回最后一个值
        return n;
    }
}
