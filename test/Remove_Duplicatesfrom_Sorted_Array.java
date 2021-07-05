/**
 * 删除有序数组中的重复项
 * 7-5
 * 双指针
 */
class Remove_Duplicatesfrom_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p=0;
        int q=1;
        while (q< nums.length)
        {
         if (nums[p] != nums[q]){//比较相邻两个数是否相等
             if (q-p>1){//防止左右不相等的时候反复赋值
                 nums[p+1] =nums[q];
             }
             p++;
         }
         q++;//相等则q向后移一位
        }
        return p+1;
    }
}
