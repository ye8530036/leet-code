/**
 * 题目：438. 找到字符串中所有字母异位词
 * 时间：11-28
 * 算法：滑动窗口+数组（双指针）
 */



import java.util.ArrayList;
import java.util.List;

class Find_Anagrams {
    public List<Integer> findAnagrams(String s,String p){
        int n = s.length(),m = p.length();
        List<Integer> res = new ArrayList<>();
        //当字符串 s 的长度小于字符串 p 的长度时，字符串 s 中一定不存在字符串 p 的异位词
        if (n<m) return res;
        //构建新数组
        int [] sCnt = new int[26];
        int [] pCnt = new int[26];
        //遍历p中是字符将之加入到pCnt当中
        for (int i=0;i<m;i++){
            pCnt[p.charAt(i)-'a'] ++;
        }
        //
        int left = 0;
        //right一步一步向右遍历s
        for (int right = 0;right<n;right++){
            int curRight = s.charAt(right)-'a';
            //将遍历的字符加入sCnt
            sCnt[curRight]++;
            //如果加入的字符不满足pCnt的字符要求，将滑动窗口左侧字符不断弹出，就是left不断右移
            while (sCnt[curRight] > pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            //当滑动窗口的长度等于p的长度时，这时的s子字符串就是p的异位词。
            if (right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }
}
