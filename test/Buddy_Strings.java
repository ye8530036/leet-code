/**
 * 题目：859. 亲密字符串
 * 时间：11-23
 * 仅需分析以下三种情况：
 * 字符串长度不相等, 直接返回false
 * 字符串相等的时候, 只要有重复的元素就返回true
 * A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
 */


class Buddy_Strings {
    public boolean buddyStrings(String s, String goal) {
        //检测词长度不相同，必不为亲密字符
        if (s.length()!=goal.length()){
            return false;
        }
        //
        int[] cnt = new int[26],cnt1 = new int[26];
        //定义一个不同字符的数量初始值
        int sum = 0;
        for (int i=0;i<s.length();i++){
            //将字符转换成阿斯克码
            int a = s.charAt(i)-'a',b = goal.charAt(i)-'a';
            cnt[a]++;
            cnt1[b]++;
            //找到一个不同字符sum加一
            if (a != b){
                sum++;
            }
        }
        boolean ok =false;
        //检测词频
        for (int i=0;i<26;i++){
            if (cnt[i] != cnt1[i]){
                return  false;
            }
            if (cnt[i] > 1){
                ok = true;
            }
        }
        //当「s 与 goal 不同的字符数量为 2（能够相互交换）」或
        //「s 与 goal 不同的字符数量为 ，但同时 s 中有出现数量超过2的字符（能够相互交换」时，两者必然为亲密字符。
        return sum ==2 || (sum==0&&ok);
    }
}
