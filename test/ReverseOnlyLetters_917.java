/**
 * 题目：只转换字母——917
 * 时间：2022-2-23
 * 算法思路：模拟
 */




class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i=0,j=n-1;i<j;){
            while (i<j&& !Character.isLetter(cs[i]))i++;
            while (i<j&& !Character.isLetter(cs[j]))j--;
            if (i<j){
                char c  = cs[i];
                cs[i] = cs[j];
                cs[j] = c;
            }
        }
        return String.valueOf(cs);
    }
}
