/**
 * 对称二叉树
 *
 * 7-30
 *
 * 深度优先搜索(递归)  DFS
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 思路及算法:
 * 如果我们知道了左子树和右子树的最大深度 l和 r，那么该二叉树的最大深度即为
 * max(l,r)+1
 */


class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root ==null)
        {
            return 0;
        }
        int maxleft = maxDepth(root.left);
        int maxright = maxDepth(root.right);
        return Math.max(maxleft,maxright)+1;
    }
}
