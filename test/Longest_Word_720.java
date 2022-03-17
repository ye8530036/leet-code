/**
 * 题目:720. 词典中最长的单词
 * 给出一个字符串数组words 组成的一本英语词典。
 * 返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * 时间：3-17
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Longest_Word_720 {
    public String longestWord(String[] words) {
        //先将数组排序
        Arrays.sort(words);
        //再利用Set对字母存储，
        //小的单词一定包含在后面大的单词里面。
        //后面只需要取前缀相同的
        //hashset不允许有重复的元素
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s:words){
            //仅有一个字母的，必定是共有的
            //contains用于检测是否含该元素返回true或者false
            if (s.length()==1 || set.contains(s.substring(0,s.length()-1))){
                //对字母排序后，第一个单词一定是共有的
                res = s.length()>res.length() ? s:res;
                //后面只需在此基础上添加
                set.add(s);
            }
        }
        return res;
    }
}
