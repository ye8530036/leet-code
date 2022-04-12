/**
 * 题目：806. 写字符串需要的行数
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 * 时间：4-12
 * 算法：直接模拟
 */



class NumberOfLine_806 {
    public int[] numberOfLines(int[] widths, String s) {
        int [] ans = new int[2];
        ans[0] = 1;
        for (char arr : s.toCharArray()){
            //arr-‘a’指代是字母在widths里的长度
            ans[1] += widths[arr-'a'];
            //累加超过100放第二行
            if (ans[1]>100){
                ans[1] = widths[arr-'a'];
                //ans[0]指行数
                ans[0]++;
            }
        }
        return ans;
    }
}
