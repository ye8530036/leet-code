import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 * 8-23
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 思路及解决方法：
 * 前序遍历：从根节点->左支树->右支树的遍历顺序进行，
 * 只需要使用递归进行遍历即可
 *
 */

class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        preorder(root,res);
        return res;
    }
    //主递归方法
    public void preorder(TreeNode root,List<Integer> res){
        if (root == null){
            return ;
        }
        //先将root的节点放入res中，再对其进行遍历
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }



}
