import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 二叉树的锯齿形层序遍历
 * 10-25
 * 给定一个二叉树的根节点 root ，返回它的层序遍历。
 * 广度优先算法(BFS)：
 * 深度优先算法(DFS)：
 * 前序遍历：中 - 左 - 右
 * 中序遍历：左 - 中 - 右
 * 后序遍历：左 - 右 - 中
 * 层序遍历：从根节点开始逐层遍历例如第一层从左至右第二层从右至左遍历所有元素
 * 时间复杂度：O（n）
 * 空间复杂度：O (n)
 */
public class BinaryTree_ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root==null){
            return ret;
        }
        //创建队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //往队列里面添加数据
        queue.offer(root);
        //逐层遍历
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            //定义每层的数据大小
            int size = queue.size();
            /*
            循环添加每一层的元素
            注意：i不可以为0即每层的元素数量不能为0
            */
            for (int i=1;i<=size;++i){
                //删除队列中第一个元素
                TreeNode node = queue.poll();
                assert node != null;
                if (ret.size()%2==0){
                    level.add(node.val);
                }
                else {
                    level.add(0, node.val);
                }
                if (node.left !=null){
                    queue.offer(node.left);
                }
                if (node.right !=null){
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
