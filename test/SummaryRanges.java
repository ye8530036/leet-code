import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * 9-29
 *
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 思路，一次遍历如相邻的元素相差大于1，即确认一个子区间，然后遍历完数组我们就能得到一个一系列的区间的列表；
 *
 *
 */


class SummaryRanges {
    public List<String> summaryRanges(int[] nums){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i< nums.length;i++){
            if (!(i< nums.length-1 && nums[i] ==nums[i+1]-1)){
                if (sb.length()>0){
                    sb.append("->");
                }
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
            else{
                if (sb.length()==0){
                    sb.append(nums[i]);
                }
            }
        }
        return ans;
    }
}
