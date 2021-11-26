/**
 * 题目：二叉搜索树中的搜索（700）
 * 时间：11-26
 * 作者：YeJiaYu
 * 思路：二叉搜索树满足如下性质：
 * 左子树所有节点的元素值均小于根的元素值；
 * 右子树所有节点的元素值均大于根的元素值。
 * 据此可以得到如下算法：
 *
 * 若 root 为空则返回空节点；
 * 若 val=root.val，则返回 root；
 * 若 val<root.val，递归左子树；
 * 若 val>root.val，递归右子树。
 *
 */



class Search_BST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val == root.val){
            return root;
        }
        return searchBST(val< root.val ? root.left :root.right,val);
    }
}
