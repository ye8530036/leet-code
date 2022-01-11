import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：230. 二叉搜索树中第K小的元素
 * 时间：1-11
 * 算法：中序遍历
 * 二叉搜索树的特点：
 * 结点的左子树只包含小于当前结点的数。
 *
 * 结点的右子树只包含大于当前结点的数。
 *
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
class KthSmallest_230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root !=null || !stack.isEmpty()){
            while (root !=null){
                //遍历左支树，将其加入栈
                stack.push(root);
                root = root.left;
            }
            //推出栈中最上面的元素计数器减一
            root = stack.pop();
            --k;
            if (k==0){
                break;
            }
            //遍历右支树
            root = root.right;
        }
        return root.val;
    }
}
