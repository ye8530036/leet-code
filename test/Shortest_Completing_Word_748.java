/**
 * 题目：748. 最短补全词
 * 时间：12-10
 * 思路：主要是记录词频，再按照题意进行判断
 * 当达到要求将单词赋值
 */


class Shortest_Completing_Word_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //统计licensePlate的词频
        int[] cnt = getCnt(licensePlate);
        String ans = null;
        //统计words的词频
        for (String s: words){
            int[] cur =getCnt(s);
            //价格判断条件
            boolean ok = true;
            for (int i=0;i < 26 && ok;i++){
                //当有字符超出，直接无法匹配
                if (cnt[i] > cur[i]){
                    ok = false;
                }
            }
            //找到合适的单词并取words中最靠前的那个
            if (ok && (ans==null || ans.length() > s.length())){
                ans = s;
            }
        }
        return ans;
    }
    //统计词频
    int[] getCnt(String s){
        int[] cnt =new int[26];
        for (char c :s.toCharArray()){
            //判断c中为字母的字符，并统计数量
            if (Character.isLetter(c)){
                //统一将大写转变为小写
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }
        return cnt;
    }
}
