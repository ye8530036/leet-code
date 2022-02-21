/**
 * 题目：838. 推多米诺
 * 时间：2022.2.21
 * 算法思路：
 * '..L' : 左侧都填充L
 * 'L..L' : 两个L之间要填充L
 * 'R..L' : R,L之间要双指针夹逼
 * 'R..R' : 两个R之间填充R
 * 'R..' : 右侧都填充R
 *
 */

import java.util.Arrays;

class PushDominoes_838 {
    public String pushDominoes(String dominoes) {
        char[] domino =dominoes.toCharArray();
        // right用来存储'R'的位置，left用来存储'L'的位置
        int right = -1,left = 0;
        for (int i=0;i <domino.length;i++){
            char c = domino[i];
            if (c=='R'){
                // R...R: 要先把两个R之间设置为R，在更新right
                if (right != -1){
                    Arrays.fill(domino,right,i,'R');
                }
                right = i;
            }
            else if (c=='L'){
                // L.. .L:要先把两个L之间都设置为L，在更新left
                // ...L :特殊情况是第一个非.字符就是L，那么0到L都填充L
                if (right==-1){
                    Arrays.fill(domino,left,i,'L');
                    left=i;
                }
                else {
                    // R...L: 双指针夹逼
                    left=i;
                    while (right<left){
                        domino[right++]='R';
                        domino[left--]='L';
                    }
                    // 初始化双指针
                    // right=-1代表没有R出现或者R被抵消
                    // left=i说明初始位置
                    right=-1;
                    left=i;
                }
            }
        }
        // R.... : 右侧全部填充R
        if (right != -1){
            Arrays.fill(domino,right,domino.length,'R');
        }
        return String.valueOf(domino);
    }
}
