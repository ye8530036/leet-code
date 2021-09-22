import java.util.HashSet;

/**
 * 存在重复元素 II
 * 9-22
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 * 思路：1.暴力破解 2.哈希表
 * 2.哈希表
 * 循环读取数组元素加入到哈希表中，但是哈希表的长度不大于2，超出的弹出先加入的，后进行比对在距离为k的地方是否有相同元素返回true与false
 */


//暴力破解
class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            for (int j = i+1; j < n ; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j)<=k){
                    return true;
                }

            }
        }
        return false;
    }
    //哈希表
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i< nums.length;i++){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
