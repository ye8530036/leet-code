/**
 * 题目：318. 最大单词长度乘积
 * 时间：11-17
 * 算法：位运算
 */
class MaxProduct {
    public int maxProduct(String[] words) {
        int length = words.length;
        int [] masks = new int[length];
        for (int i=0;i<length;i++){
            //将词组中的单词一一放入字符串中
            String word = words[i];
            for (int j=0;j< word.length();j++){
                //利用位运算来对比对照数组中的词组和字符串中的词
                masks[i] |= 1<<(word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                //判定是否有公共的字母
                if ((masks[i]&masks[j]) ==0){
                    //计算比较得出不含有公共字母的最大单词的长度
                    maxProd = Math.max(maxProd,words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
