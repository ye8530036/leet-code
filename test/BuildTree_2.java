import java.util.Arrays;

/**
 * 以后序遍历和中序来构建二叉树
 * 10-26
 * 思路：前序/后序+中序序列可以唯一确定一棵二叉树，所以自然而然可以用来建树
 * 方法：递归
 * 中序遍历：左 - 根 - 右
 * 后序遍历：左 - 右 - 根
 * 由此可以反推出树
 * 层序遍历：从根节点开始逐层从左至右遍历所有元素
 * 时间复杂度：O（n）
 * 空间复杂度：O (n)
 */


class BuildTree_2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //postorder(后序)，inorder(中序)
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i=0;i< postorder.length;i++){
            if (postorder[postorder.length-1]==inorder[i]){
                //copyOfRange主要用于对一个已有的数组进行截取复制，复制出一个左闭右开[left,right)区间的数组
                //创建左支树
                root.left = buildTree(Arrays.copyOfRange(inorder,0,i+1),Arrays.copyOfRange(postorder,0,i+1));
                //创建右支树
                root.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
                break;
            }
        }
        return root;
    }
}
