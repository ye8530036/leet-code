import java.util.HashMap;
/**
 * 无重复字符的最长子串
 * 10-28
 * 方法：滑动窗口
 * 思路：设置左右坐标，右坐标移动对比散列表没有发现重复字符则将统计的最长长度加一
 * 但是当发现重复字符则移动左坐标缩小滑动窗口直到发现新的非重复字符
 * 时间复杂度：O（n）
 * 空间复杂度：O (n)
 */
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        //最长子串长度
        int max=0;
        //滑动窗口左下标，i为滑动窗口右下标
        int left = 0;
        for (int i=0;i<s.length();i++)
        {
            //检测是否为重复字符
            if (map.containsKey(s.charAt(i))){
                //左下标加一
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //更新map中映射的下标
            map.put(s.charAt(i),i);
            //返回最长子串
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
