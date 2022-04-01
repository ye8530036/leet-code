import java.util.TreeMap;

/**
 * 题目：1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * 时间：2022-3-30
 */

class LongestSubarray_1438 {
    public int longestSubarray(int[] nums, int limit) {
        //TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序
        TreeMap<Integer,Integer> map =  new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0 ,right = 0;
        int ret = 0;
        //限定边界
        while (right<n){
            //lastKey()最后一个元素，firstKey()第一个元素
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            //设定滑动窗口
            while (map.lastKey() - map.firstKey() >limit){
                map.put(nums[left],map.get(nums[left])-1);
                if (map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}
