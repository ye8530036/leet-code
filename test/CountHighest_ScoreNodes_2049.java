/**
 * 题目：2049. 统计最高分的节点数目
 * 时间：3-11
 * 算法：dfs（深度搜索算法）
 *
 */

class CountHighest_ScoreNodes_2049 {
    long maxScore = 0;
    int ans = 0;
    int n;
    public int countHighestScoreNodes(int[] parents) {
        // 删除一个节点最多把整颗树分割成三部分：左子树、右子树、父节点及父节点的另一半子树
        // 而我们需要先构造出来这颗树才能通过DFS遍历
        this.n = parents.length;

        int[] left  = new int[n];
        int[] right = new int[n];
        for (int i=0;i<n;i++){
            left[i] = -1;
            right[i] = -1;
        }

        for (int i=1;i<n;i++){
            int p = parents[i];
            if (left[p]==-1){
                left[p] = i;
            }else {
                right[p] = i;
            }
        }
        dfs(0,left,right);
        return ans;
    }
    private int dfs (int node,int[] left,int[] right){
        if (node == -1){
            return 0;
        }
        int leftCount = dfs(left[node],left,right);
        int rightCount = dfs(right[node],left,right);
        // 所以，我们可以遍历每个节点的左右子树的数目，父节点及父节点的另一半子树的数量就等于 总节点数 减去 左右子树的数目 再减 一
        int remain = n - leftCount - rightCount -1;
        // 三者相乘就是分数，没有的部分用 1 代替
        long score = help(leftCount) * help(rightCount) * help(remain);
        if (score==maxScore){
            ans++;
        }else if (score>maxScore){
            maxScore = score;
            ans = 1;
        }
        return leftCount+rightCount+1;
    }
    private long help(int count){
        return count == 0 ? 1 :count;
    }
}
