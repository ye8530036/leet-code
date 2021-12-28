/**
 * 题目：686. 重复叠加字符串匹配
 * 时间：12-22
 * 思路：运用上下界来界定字符串的最小复制次数
 * 以此来匹配b，就能得出重复叠加的次数
 */

class Repeated_String_Match_686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //复制次数
        int ans = 0;
        //复制a的字符达到b的下界
        //即a复制的最小次数得到的字符串大于等于b的长度
        //但是我们需要的是上界来匹配最小次数
        //上界即为下界+1
        while (sb.length()<b.length() && ++ans>0){
            sb.append(a);
        }
        sb.append(a);
        //匹配
        int idx = sb.indexOf(b);
        //匹配失败
        if (idx == -1){
            return -1;
        }

        return idx + b.length()>a.length()*ans ? ans + 1 :ans;
    }
}
