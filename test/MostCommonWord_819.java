import java.util.*;

/**
 * 题目：819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。
 * 返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 时间：4-17
 * 算法：模拟
 */
class MostCommonWord_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        //将banned中的字符逐一加入到b中
        for (String b:banned){
            set.add(b);
        }
        char [] cs = paragraph.toCharArray();
        int n = cs.length;
        String ans = null;
        //创建一个map
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0;i<n;){
            //Character.isLetter() 方法用于判断指定字符是否为字母
            //排除空格和逗号
            if (!Character.isLetter(cs[i]) && ++i >=0){
                continue;
            }
            int j=i;
            while (j<n &&Character.isLetter(cs[j])){
                j++;
            }
            //获取到各个单词存入sub
            String sub = paragraph.substring(i,j).toLowerCase();
            i = j+1;
            if (set.contains(sub)){
                continue;
            }
            //比对sub中所有单词的个数，将最多的放入ans
            map.put(sub,map.getOrDefault(sub,0)+1);
            if (ans ==null || map.get(sub) >map.get(ans)){
                ans=sub;
            }
        }
        return ans;
    }
}
