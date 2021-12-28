/**
 * 题目：825. 适龄的朋友
 * 时间：12-27
 * 思路算法：排序＋双指针
 * 即有条件归纳得出0.5×ages[x]+7<ages[y]≤ages[x]
 * 来确定左右范围的值
 */

import java.util.Arrays;

class Num_Friend_Requests_825 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int ans =0,left =0,right = 0;
        for (int age : ages ){
            if (age<15){
                continue;
            }
            //找到满足第一条件的左边界
            while (ages[left]<=0.5 * age + 7){
                ++left;
            }
            //以第二条件的反例来约束右边界
            //ages[y]>ages[x]
            //即当ages[y]<=ages[x]时向右遍历
            while (right+1<n && ages[right+1]<=age){
                ++right;
            }
            //即左右边界确定的值都满足
            //0.5×ages[x]+7<ages[y]≤ages[x]
            ans +=right-left;
        }

        return ans;
    }
}
