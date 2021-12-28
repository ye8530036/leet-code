/**
 * 题目：1078. Bigram 分词
 * 时间：12-26
 * 算法思路：首先将字符串放列表中，再遍历比对，当符合条件时输出所需的字符
 */



import java.util.ArrayList;
import java.util.List;

class Find_Ocurrences_1078 {
    public String[] findOcurrences(String text, String first, String second) {
        //利用空格拆分字符串
        String[] sb = text.split(" ");
        //新建表
        List<String> list = new ArrayList<>();
        int n = sb.length;
        for (int i=0 ;i+2<n;i++){
            if (sb[i].equals(first) && sb[i+1].equals(second)){
                //将third加入表中
                list.add(sb[i+2]);
            }
        }
        //返回third
        return list.toArray(new String[0]);
    }
}
