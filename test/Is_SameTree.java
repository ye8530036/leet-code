/**
 * 相同的树
 *
 * 7-28
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 深度优先搜索(递归)
 *
 * 首先如果俩树为空，则返回true，否则任意一树有为空则返回false，其次比较根节点，如不相等则为false
 *
 * 之后递归调用方法比较左右节点的值
 *
 */

class Is_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
        {
            return true;
        }
        else if (p==null || q==null)
        {
            return false;
        }
        else if (p.val != q.val)
        {
            return false;
        }
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
