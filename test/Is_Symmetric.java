/**
 * 对称二叉树
 *
 * 7-29
 *
 *  给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * 深度优先搜索(递归)
 *
 * 首先如果俩树为空，则返回true，否则任意一树有为空则返回false，
 * 之后递归调用方法比较对称节点的值以及根节点，如不相等则为false
 *
 */
class Is_Symmetric {
    public boolean isSymmetric(TreeNode root) {
      return   check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q)
    {
        if (p==null && q==null)
        {
            return true;
        }
        else if (p ==null ||q ==null)
        {
            return false;
        }
        return p.val==q.val && check(p.left,q.right) && check(p.right, q.left);
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
