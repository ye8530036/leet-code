import java.util.ArrayList;
import java.util.List;

/**
 * 题目：2200. 找出数组中的所有 K 近邻下标
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。
 * K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 * 思路：快慢指针
 *
 */

public class FindKDistantIndices_2200 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        for (int i=0, j = 0; i < n ;i++){
            //continue 语句会终止本次循环,意在找到Key
            if (nums[i] != key)
                continue;
            //快指针从左往右遍历数组，如果找到了 key，就用慢指针扫过 [j - k, j + k] 这个区间，并记录这个区间的所有“合法”下标。
            while (j<i-k)
                j++;
            while (j<n && j<=i+k){
                ans.add(j);
                j++;
            }
        }
        return ans;
    }
}
