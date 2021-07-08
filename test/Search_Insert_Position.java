/**
 * 搜索插入位置
 * 7-8
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 注意：注意当left<=right时right = nums.length-1在注意3处right = mid - 1
 * 但是当left<right时right = nums.length在注意3处right = mid
 * 使用二分法执行查询插入
 */

class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;//注意1
        while (left<=right){                //注意2
            int mid = (left +right) /2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1 ;
            } else {
                right = mid - 1;            //注意3
            }
        }
        return left;
    }
}
