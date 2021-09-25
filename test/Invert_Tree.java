/**
 * 反转二叉树
 * 9-25
 * 翻转一棵二叉树。
 * 思路：递归
 * 从根节点往下遍历以中左右来遍历（前序遍历）
 * 也可以用左右中来遍历实现（后序遍历）
 */

class Invert_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swapChildren(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
