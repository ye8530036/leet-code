import java.util.HashSet;
import java.util.Set;

/**
 * 题目：653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 时间：2022-3-21
 */

class FindTarget {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        //检查节点
        if (root == null){
            return false;
        }
        //遍历搜索如果set中存在差值则返回true
        if (set.contains(k- root.val)){
            return true;
        };
        set.add(root.val);
        //递归调用
        return findTarget(root.left,k) ||findTarget(root.right,k);
    }
}
