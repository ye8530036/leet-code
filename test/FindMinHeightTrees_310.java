import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 * 例子：
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 时间：2022-4-6
 */
class FindMinHeightTrees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }
        //建立各个节点的出度表
        int[] degree = new int[n];
        //建立图关系，在每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i =0;i<n;i++){
            map.add(new ArrayList<>());
        }
        for (int[] edge:edges){
            degree[edge[0]]++;
            //度++
            degree[edge[1]]++;
            //添加相邻节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //建立队列
        Queue<Integer> queue = new LinkedList<>();
        //把所有度为1的节点，也就是叶子节点入队
        for (int i=0;i < n ;i++){
            if (degree[i]==1){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            //这个地方注意，我们每层循环都要new一个新的结果集合
            //这样最后保存的就是最终的最小高度树了
            res = new ArrayList<>();
            //size是每一层的节点的数量
            int size = queue.size();
            for (int i=0;i<size;i++){
                //因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点
                //这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完
                //都会把该层（也就是叶子节点层）这一层从队列中移除掉
                //不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                //bfs,把当前节点的相邻节点都拿出来
                //将他们的度都减1，因为当前节点已经不在了
                //所有它的相邻节点就有可能变成叶子结点
                for (int neighbor:neighbors){
                    degree[neighbor]--;
                    if (degree[neighbor]==1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
