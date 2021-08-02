/**
 * 将有序数组转换为二叉搜索树
 *
 * 7-31
 *
 * 深度优先搜索(递归)
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 * 思路及算法:
 * 我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 11，可以使得树保持平衡。
 *
 * 如果数组长度是奇数,则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点。
 *
 * 选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
 *
 * 关键在于mid的取值
 */


class SortedArray_BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }

    public TreeNode bst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //中序遍历，总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, left, mid - 1);
        root.right = bst(nums, mid + 1, right);
        return root;
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
