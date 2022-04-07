/**
 * 题目：796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * 时间：2022-4-7
 */



class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        //s+s包含了所有移动的情况，假如包含goal则返回true
        return s.length()==goal.length()&&(s+s).contains(goal);
    }
}
