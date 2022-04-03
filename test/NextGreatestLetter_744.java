/**
 * 题目：744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * 时间：2022-4-3
 */



class NextGreatestLetter_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        //循环遍历letters
        for(char x:letters){
            //找到符合条件的返回
            if(x>target) return x;
        }
        //否则返回数组头一个字符
        return letters[0];
    }
}
