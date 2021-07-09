/**
 * 最大子序和
 * 7-9
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0],sum=0;
        for (int num:nums){
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
