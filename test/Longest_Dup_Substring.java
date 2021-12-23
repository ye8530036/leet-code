/**
 * 题目：1044. 最长重复子串
 * 时间：12-23
 * 算法：二分+字符串哈希
 */



import java.util.HashSet;
import java.util.Set;

class Longest_Dup_Substring {
    long [] h,p;
    public String longestDupSubstring(String s) {
        int P = 1313131 ,n = s.length();
        h = new long[n+10];
        p = new long[n+10];
        p[0] =1;
        for (int i=0; i<n ;i++){
            p[i+1] = p[i] * P;
            h[i+1] = h[i] * P +s.charAt(i);
        }
        String ans = "";
        //二分主体，来查找最长重复字串
        int l =0,r = n;
        while (l<r){
            int mid = l+r+1>>1;
            String t =check(s,mid);
            if (t.length()!=0){
                l = mid;
            }
            else r = mid -1;
            ans = t.length() >ans.length() ? t :ans;
        }
        return ans;
    }
    //检查子串是否是长度len作为最大长度，是否存在合法方案
        String check(String s,int len){
            int n = s.length();
            Set<Long> set = new HashSet<>();
            for (int i=1;i+len-1 <=n;i++){
                int j=i+len -1;
                long cur = h[j]-h[i-1]*p[j-i+1];
                if (set.contains(cur)) {
                    return s.substring(i - 1, j);
                }
                    set.add(cur);
            }
            return "";
    }
}
