/**
 * 题目：747. 至少是其他数字两倍的最大数
 * 时间：1-13
 * 算法思路：模拟
 * 具体做法看代码注解
 */




class DominantIndex_747 {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return 0;
        }
        int a=-1,b=0;
        for (int i=1;i<n;i++){
            //找最大值nums[b]
            if (nums[i]>nums[b]){
                a = b;b=i;
            }
            //找次大值nums[a]
            else if (a==-1||nums[i]>nums[a]){
                a=i;
            }
        }
        //找到输出最大值的下标
        return nums[b]>=nums[a] * 2 ? b :-1 ;
    }
}
