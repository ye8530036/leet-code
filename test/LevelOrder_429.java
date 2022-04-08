import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 时间：2022-4-8
 * 算法：BFS
 */

class LevelOrder_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        //BFS主要是由队列来实现
        Deque<Node> d = new ArrayDeque<>();
        if (root != null){
            //将节点加入队列
            d.addLast(root);
        }
        while (!d.isEmpty()){
            int size = d.size();
            List<Integer> list = new ArrayList<>();
            while (size-->0){
                //生成二叉树
                Node t = d.pollFirst();
                //开始层序遍历
                for (Node node :t.children){
                    d.addLast(node);
                }
                list.add(t.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
