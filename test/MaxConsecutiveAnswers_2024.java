/**
 * 题目：2024. 考试的最大困扰度
 * 一位老师正在出一场由 n道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F'表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是最大化有 连续相同结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串answerKey，其中answerKey[i]是第 i个问题的正确结果。除此以外，还给你一个整数 k，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为'T' 或者'F'（也就是将 answerKey[i] 改为'T'或者'F'）。
 * 请你返回在不超过 k次操作的情况下，最大连续 'T'或者 'F'的数目。
 * 时间：2022-3-29
 */


class MaxConsecutiveAnswers_2024 {
    String s;
    int n,_k;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        s = answerKey;
        n = s.length();
        _k = k;
        //比较变T长还是变F长
        return Math.max(getCnt('T'),getCnt('F'));
    }
    int getCnt(char c){
        //初始化ans
        int ans = 0;
        for (int i=0,j=0,cnt=0;i<n;i++){
            if (s.charAt(i)==c)
                cnt++;
            //统计T或者F的数量
            while (cnt >_k){
                if (s.charAt(j)==c){
                    cnt--;
                }
                j++;
            }
            ans = Math.max(ans,i-j+1);
        }
        //统计连续字母的长度
        return ans;
    }
}
