import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长定差子序列
 * 算法：动态规划
 * 遍历一遍数组并计算出以arr[i]为结尾的最长的等差子序列的长度，取所有长度的最大值
 *
 */



public class Longest_Subsequence {
    public int longestSubsequence(int[] arr, int difference) {
        //初始化最长定差子序列
        int ans=0;
        //创建HashMap：bp
        Map<Integer,Integer> bp = new HashMap<Integer,Integer>();
        //将数组arr逐个放入v中跑循环
        for (int v:arr){
            //将bp中放入等差的元素
            bp.put(v,bp.getOrDefault(v-difference,0)+1);
            //找出最长的等差元素序列
            ans = Math.max(ans,bp.get(v));
        }
        return ans;
    }
}
