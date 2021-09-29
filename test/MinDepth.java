/**
 * 二叉树的最小深度
 *
 * ８-3
 *
 * 深度优先搜索(递归)
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 思路及算法:
 *
 * 首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
 *
 * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。
 *
 * 这样就将一个大问题转化为了小问题，可以递归地解决该问题。
 */

class MinDepth {
    public int minDepth(TreeNode root) {
        if (root ==null)
        {
            return 0;
        }
        // 计算左子树的深度
        int left = minDepth(root.left);
        // 计算右子树的深度
        int right = minDepth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }

}
