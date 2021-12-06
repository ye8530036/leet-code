/**
 * 题目：1816. 截断句子
 * 时间：12-6
 * 算法：暴力（找规律）
 *
 */
class Truncate_Sentence {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        //count用来记录单词的数量，end为句子结尾位置
        int end = 0,count = 0;
        for (int i=0;i<=n;i++){
            //遍历到末尾即整句话不需要截取，或者遇到空格计算单词数量
            if (i==n || s.charAt(i)==' '){
                count++;
                if (count ==k){
                    end = i;
                    break;
                }
            }
        }
        //截取0到end的字符
        return s.substring(0,end);
    }
}
