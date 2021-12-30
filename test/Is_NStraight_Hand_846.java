/**
 * 题目：846. 一手顺子
 * 时间：12-30
 * 算法思路：首先我们统计词频，按组分配
 * 每一组顺子都有最小的值，我们按照最小值组成顺子
 * 直到无法组成为止，如果正好则返回True
 * 如果失败则返回false，这里我们采用的是哈希表和贪心算法
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Is_NStraight_Hand_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> hands= new HashMap<>();
        if (hand.length %groupSize !=0){
            return false;
        }
        for (int h :hand){
            //按照hand中（元素，词频）的形式加入到哈希表中
            hands.put(h,hands.getOrDefault(h,0)+1);
        }
        //贪心策略，从小到大检验并排序
        Arrays.sort(hand);
        for (int h:hand){
            if (hands.get(h)>0){
                for (int i=h;i<h+groupSize;i++){
                    //如果没有该元素则直接返回False
                    if (!hands.containsKey(h) || hands.get(i)==0){
                        return false;
                    }
                    //消耗一次该数字，词频-1
                    hands.put(i, hands.get(i)-1);
                }
            }
        }
        return true;
    }
}
