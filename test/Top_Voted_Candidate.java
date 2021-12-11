/**
 * 题目:911. 在线选举
 * 时间：12-11
 * 算法：二分
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Top_Voted_Candidate {
    //创建一个list来记录不同时刻的候选人交替情况
    List<int[]> list = new ArrayList<>();
    //time数组严格递增以此来
    public void TopVotedCandidate(int[] persons, int[] times) {
        //初始化val
        int val = 0;
        Map<Integer,Integer> map =new HashMap<>();
        for (int i=0;i<times.length;i++){
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
            //利用val来维护当前得票最大数量
            if (map.get(persons[i])>=val){
                val = map.get(persons[i]);
                //当票数大于val时们往 list 追加二元组记录 list[idx] = (times[i], persons[i])，并更新 val
                list.add(new int[]{times[i],persons[i]});
            }
        }
    }
    //二分查找找到 list 中满足 list[i][0] <= t 的分割点 r（最大下标）
    public int q(int t) {
        int l=0,r=list.size()-1;
        while (l < r){
            //中间点mid >> 1,相当于mid除以2,即二分
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0]<=t){
                l=mid;
            }
            else {
                r=mid-1;
            }
        }
        return list.get(r)[0] <=t ? list.get(r)[1]:0;
    }
}
