/**
 * 题目：（383）赎金信
 * 时间：12-4
 * 算法：抵消；数组的词频统计
 */



class Can_Construct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        //循环记录杂志中的每个字母的阿斯克码，进行每个字符的词频统计，并存入数组中
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;}
        //循环比对抵消记录的字母若词频出现负数，则说明magazine无法凑出ransomNote
        // 类似于aa，ab，其中magazine中a词频为1，但是ransomNote有2个a就会导致a的词频为负，从而得出false
        for (char c : ransomNote.toCharArray()) {
            if (--cnt[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
