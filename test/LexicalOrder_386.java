import java.util.ArrayList;
import java.util.List;

/**
 * 题目：386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * 递归+dfs
 */

public class LexicalOrder_386 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        //每个节点有10个子节点,跳过根节点
        for (int i=1;i<=9;i++){
            //dfs得出ans
            dfs(i,n);
        }
        return ans;
    }
    void dfs(int cur,int limit){
        if (cur > limit) return ;
        //添加答案进表
        ans.add(cur);
        //递归主题
        for (int i=0;i<=9;i++){
            dfs(cur*10+i,limit);
        }
    }
}
