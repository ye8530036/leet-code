import java.util.HashSet;
import java.util.Set;

class UniqueMorse_804 {
    String [] ss = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        //HashSet确保没有重复元素
        Set<String> set = new HashSet<>();
        //循环将words的单词加入到s
        for (String s:words){
            //StringBuilder支持链式操作
            StringBuilder sb = new StringBuilder();
            for (char c:s.toCharArray()){
                //将转换的摩斯码存入sb
                sb.append(ss[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
