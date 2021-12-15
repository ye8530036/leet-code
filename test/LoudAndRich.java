/**
 * 题目：851. 喧闹和富有
 * 时间：12-15
 * 算法：dfs
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i=0;i<n;++i){
            g[i] = new ArrayList<Integer>();
        }
        for(int[] r:richer){
            g[r[1]].add(r[0]);
        }

        int[] ans = new int[n];
        //填充a1数组中的每个元素都是value
        Arrays.fill(ans,-1);
        //对每个点进行dfs遍历它的所有邻居节点
        for (int i=0;i<n;++i){
            dfs(i,quiet,g,ans);
        }
        return ans;
     }
     //dfs（深度优先搜索）主体
     public void dfs (int x,int[] quiet,List<Integer>[] g,int[] ans){
        if (ans[x] != -1){
            return;
        }
        ans[x] = x;
        //利用递归来计算x的每个邻居
        for (int y :g[x]){
            dfs(y,quiet,g,ans);
            if (quiet[ans[y]] < quiet[ans[x]]){
                ans[x] = ans[y];
            }
        }
     }
}
