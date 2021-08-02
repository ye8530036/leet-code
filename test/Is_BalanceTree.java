/**
 * 是否为平衡二叉树
 *
 * ８-2
 *
 * 深度优先搜索(递归)
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 思路及算法:
 * 自顶向下的递归
 * 计算高度，进行比较，再递归比较左右支树
 * height(p)=
 * 0                                          =>p 是空节点
 * max(height(p.left),height(p.right))+1      =>p 是非空节点
 */

class Is_BalanceTree {
    public boolean isBalanced(TreeNode root)
    {
        if (root ==null)
        {
            return true;
        }
        else return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int height(TreeNode root)
    {
        if (root ==null)
        {
            return 0;
        }
        else return Math.max(height(root.left),height(root.right))+1;

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
