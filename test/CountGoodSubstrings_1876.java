/**
 * 题目：1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * 子字符串 是一个字符串中连续的字符序列。
 * 时间：2022-4-2
 */

class CountGoodSubstrings_1876 {
    public int countGoodSubstrings(String s) {
        if (s.length()<3){
            return 0;
        }
        char[] ans = s.toCharArray();
        int count=0;
        for (int i=0;i+2<s.length();i++){
            //比对三个字符的子串是否为好子字符串
            if (ans[i]!=ans[i+1] && ans[i]!=ans[i+2] && ans[i+1]!=ans[i+2]){
                count++;
            }
        }
        return count;
    }
}
