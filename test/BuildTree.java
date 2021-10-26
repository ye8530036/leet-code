import java.util.Arrays;

/**
 * 以前序遍历和中序来构建二叉树
 * 10-26
 * 思路：前序/后序+中序序列可以唯一确定一棵二叉树，所以自然而然可以用来建树
 * 方法：递归
 * 前序遍历：根 - 左 - 右
 * 中序遍历：左 - 根 - 右
 * 由此可以反推出树
 * 层序遍历：从根节点开始逐层从左至右遍历所有元素
 * 时间复杂度：O（n）
 * 空间复杂度：O (n)
 */

class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder(前序)，inorder(中序)
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=0;i< preorder.length;i++){
            if (preorder[0]==inorder[i]){
                //copyOfRange主要用于对一个已有的数组进行截取复制，复制出一个左闭右开[left,right)区间的数组
                //创建左支树
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                //创建右支树
                root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }
}
