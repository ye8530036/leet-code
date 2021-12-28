/**
 * 题目：1674. 使数组互补的最少操作次数
 * 时间：11-16
 * 2 ~ min : 2次
 * min + 1 ~ min + max - 1 : 1次
 * min + max : 0次
 * min + max + 1 ~ max + limit : 1次
 * max + limit + 1 ~ 2 * limit ：2次
 *
 *
 */



class Min_Moves_1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int [] diff = new int[2 * limit + 2];
        for (int i = 0;i< nums.length / 2;i++){
            int max = Math.max(nums[i],nums[n-i-1]);
            int min = Math.min(nums[i],nums[n-i-1]);
            diff[1] += 2;
            diff[min + 1] -= 1;
            diff[min + max] -= 1;
            diff[min + max + 1] += 1;
            diff[max + limit +1] += 1;
        }
        int ans = diff[1];
        for (int i=2;i< 2 * limit + 1;i++){
            diff[i] += diff[i-1];
            ans = Math.min(ans,diff[i]);
        }
        return ans;
    }
}
