import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历
 * 9-7
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 * 思路及解决方法：
 * 前序遍历：从左子树——右子树——根节点的遍历顺序进行，
 * 只需要使用递归进行遍历即可
 *
 */



class PostorderTraversal {
    //主程序体
    public List<Integer> PostorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Postorder(root,res);
        return res;
    }
    //主递归程序
    public void Postorder (TreeNode root,List<Integer> res){
        if (root == null){
            return ;
        }
        Postorder(root.left, res);
        Postorder(root.right, res);
        res.add(root.val);
    }

    //二叉树本体
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
