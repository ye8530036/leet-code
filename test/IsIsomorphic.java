/**
 * 同构字符串
 * 9-18
 * 给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 思路：
 * 循环对比索引的下标，来比对两个字符串是不是同构字符串
 */

class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        for(int i=0;i<s.length();i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
             }
        }
        return true;
    }
}
