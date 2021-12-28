import java.util.HashMap;
import java.util.Map;

/**
 * 题目：从英文中重建数字（423）
 * 时间：11-24
 * 思路及解法：这是一道脑经急转弯的题目；对比数字的英文和数字我们不难发现,w,u,x,g 都只在一个数字中，即 0, 2, 4, 6, 8中出现。
 * 因此我们可以使用一个哈希表统计每个字母出现的次数，那么 z,w,u,x,g 出现的次数，即分别为 0, 2, 4, 6, 8出现的次数。
 * 随后我们可以注意那些只在两个数字中出现的字符：
 * h 只在 3, 8 中出现。由于我们已经知道了 8 出现的次数，因此可以计算出 3 出现的次数。
 * f 只在 4, 5中出现。由于我们已经知道了 4 出现的次数，因此可以计算出 5 出现的次数。
 * s 只在 6, 7中出现。由于我们已经知道了 6 出现的次数，因此可以计算出 7 出现的次数。
 * 此时，我们还剩下 1 和 9 的出现次数没有求出：
 * o只在 0, 1, 2, 4中出现，由于我们已经知道了 0, 2, 4出现的次数，因此可以计算出 1 出现的次数。
 * 最后的 9 就可以通过 n,i,e 中的任一字符计算得到了。这里推荐使用 i 进行计算，因为 n 在 9 中出现了 2 次，e 在 3 中出现了 2 次，容易在计算中遗漏。
 * i    5 6 8 9
 * e	0 1 3 5 7 8 9
 * f	4 5
 * g	8
 * h	3 8
 * i	5 6 8 9
 * n	1 7 9
 * o	0 1 2 4
 * r	0 3 4
 * s	6 7
 * t	2 3 8
 * u	4
 * v	5 7
 * w	2
 * x	6
 * z	0
 */


class Original_Digits_423 {
    public String originalDigits(String s) {
        //开辟利用键值对应数据的接口来储存相应字母键值对应的是该字母出现的次数
        Map<Character,Integer> c = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();++i){
            char ch = s.charAt(i);
            //对出现一次键值加一
            c.put(ch,c.getOrDefault(ch,0)+1);
        }
        int [] cnt = new int[10];
        //根据字母来记录各个数字出现的次数
        cnt[0] = c.getOrDefault('z',0);
        cnt[2] = c.getOrDefault('w',0);
        cnt[4] = c.getOrDefault('u',0);
        cnt[6] = c.getOrDefault('x',0);
        cnt[8] = c.getOrDefault('g',0);
        cnt[3] = c.getOrDefault('h',0)-cnt[8];
        cnt[5] = c.getOrDefault('f',0)-cnt[4];
        cnt[7] = c.getOrDefault('s',0)-cnt[6];
        cnt[1] = c.getOrDefault('o',0)-cnt[0]-cnt[2]-cnt[4];
        cnt[9] = c.getOrDefault('i',0)-cnt[5]-cnt[6]-cnt[8];
        //重新按照升序拼接数字
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<10;++i){
            for (int j=0;j< cnt[i];++j){
            ans.append((char) (i+'0'));
            }
        }
        return ans.toString();
    }
}
