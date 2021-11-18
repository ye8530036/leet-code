/**
 * 题目：563. 二叉树的坡度
 * 时间：11-18
 * 算法：深度搜索算法
 * 首先我们需要遍历每一个节点，然后计算该节点的所以左节点和右节点的和再相减。取他们的绝对值即该节点的坡度
 */



class Find_Tilt {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    //
    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        //累加该节点所有左支树
        int sumLeft = dfs(node.left);
        //累加该节点所有的右支树
        int sumRigh = dfs(node.right);
        //abs为取绝对值（累加坡度）
        ans += Math.abs(sumLeft-sumRigh);
        return sumLeft+sumRigh+node.val;
    }
}
