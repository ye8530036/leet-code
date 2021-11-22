/**
 * 题目：N叉树的最大深度（559）
 * 时间：11-21
 * 算法：DFS
 */



class NX_tree_MaxDepth {
    public int maxDepth(Node root) {
        if(root ==null)
            return 0;
        //将最大深度初始化
        int max_depth =0;
        //从子节点开始找
        for (Node node : root.children){
            //递归返回子节点中的最大深度(递归子节点到子叶节点来得出最大深度)
            max_depth = Math.max(max_depth,maxDepth(node));
        }
        //加上根节点的深度
        return max_depth+1;
    }
}
