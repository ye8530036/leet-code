/**
 * 题目：997. 找到小镇的法官
 * 时间：12-19
 * 思路：将题目装换成有向图将人看成点
 * 每个人都有出度和入度，法官由于不相信任何人，所以法官无出度
 * 且每个人都相信法官，所以法官入度为n-1我们只需遍历所有节点找到出度入度相符的点即为法官
 */

class Find_Judge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for (int[] edg :trust){
            //记录每个节点的出入度
            int x = edg[0],y = edg[1];
            ++inDegree[y];
            ++outDegree[x];
        }
        //找到法官
        for (int i=1;i<=n;++i){
            //法官入度为n-1，出度为0
            if (inDegree[i] == n-1 && outDegree[i]==0){
                return i;
            }
        }
        return -1;
    }
}
