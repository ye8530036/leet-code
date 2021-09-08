/**
 * 二叉树的中序遍历
 * 7-27
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 递归(先递归左节点，再根节点)
 *
 * 前序遍历：中 - 左 - 右
 * 中序遍历：左 - 中 - 右
 * 后序遍历：左 - 右 - 中
 *
 */


import java.util.ArrayList;
import java.util.List;

class BinaryTree_InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    void dfs(List<Integer> res,TreeNode root){
        if (root == null){return;}
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
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
