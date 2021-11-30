/**
 * 题目：880. 索引处的解码字符串
 * 时间：11-29
 * 算法：首先，找出解码字符串的长度。之后，我们将逆向工作，跟踪 size：
 * 解析符号 S[0], S[1], ..., S[i] 后解码字符串的长度。
 * 如果我们看到一个数字 S [i]，
 * 则表示在解析 S [0]，S [1]，...，S [i-1] 之后解码字符串的大小将是 size / Integer(S[i])。 否则，将是 size - 1
 *
 */




class DecodeAt_Index {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int N = s.length();
        for (int i=0;i<N;i++){
            char c =s.charAt(i);
            //isDigit用来判断c是否为数字，当碰到数字时则返回单词长度
            if (Character.isDigit(c)){
                size *= c - '0';
            }else {
                size++;
            }
        }
        //进行逆向工作跟踪size
        for (int i =N-1;i>=0;--i){
            char c = s.charAt(i);
            //索引K的答案和K%size的答案相同
            k %= size;
            //得出索引k相应的字符
            if (k==0 && Character.isLetter(c)) {
                return Character.toString(c);}

            if (Character.isDigit(c)){
                size /= c-'0';
            }
            else {
                size--;
            }
        }
        throw  null;
    }
}
