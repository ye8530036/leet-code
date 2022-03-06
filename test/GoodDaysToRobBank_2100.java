import java.util.ArrayList;
import java.util.List;

/**
 * 题目：2100. 适合打劫银行的日子
 * 时间：2022-3-6
 * 算法：DP（动态规划）
 */



class GoodDaysToRobBank_2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
       int len = security.length;
       int[] left = new int[len];
       int[] right = new int[len];
       for (int i=1;i<len;i++){
           //确保i之前的都是递减
           if (security[i]<=security[i-1]){
               left[i] = left[i - 1] + 1;
           }
           //确保i之后的都是递增
           if (security[len-i-1]<=security[len-i]){
               right[len-i-1] =right[len-i]+1;
           }
       }
       List<Integer> ans = new ArrayList<>();
       for (int i=time;i<len-time;i++){
           //确保间隔是大于等于time
           if (left[i]>=time&&right[i]>=time){
               //将所有的i加入答案
               ans.add(i);
           }
       }
       return ans;
    }
}
