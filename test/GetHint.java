/**
 * 题目：猜数字游戏（299）
 * 时间：11-8
 * 算法：遍历
 * 思路具体看备注
 */

class GetHint {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int [] countS =new int[10];
        int [] countG =new int[10];
        for (int i=0;i<secret.length();++i){
            //统计公牛
            if (secret.charAt(i)==guess.charAt(i)){
                bull++;
            }//不相等时统计词频
            else {
             ++countS[secret.charAt(i)-'0'];
             ++countG[guess.charAt(i)-'0'];
            }
        }
        //统计奶牛
        int cow = 0;
        for (int i=0;i<10;i++){
            //奶牛就等于在secret与guess中词频出现的最小值的累加
            cow += Math.min(countS[i],countG[i]);
        }
        return Integer.toString(bull) + 'A' + Integer.toString(cow)+'B';
    }
}
