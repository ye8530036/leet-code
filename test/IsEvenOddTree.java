import java.util.ArrayDeque;
import java.util.Deque;

class IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        //判断是否是偶数层
        boolean flag = true;
        //在队列末尾添加节点
        d.addLast(root);
        while (!d.isEmpty()){
            int size = d.size(), prev = flag ? 0 :0x3f3f3f3f;
            while (size-->0){
                TreeNode node = d.pollFirst();
                //记录层数
                int cur = node.val;
                //prev记录的是上一节点的值
                //当偶数层递减时返回false
                if (flag && (cur % 2 ==0 ||cur<=prev)){
                    return false;
                }
                //奇数层递增时返回false
                if (!flag && (cur %2 !=0 ||cur>=prev)){
                    return false;
                }
                //到下一层，将下层的节点入列
                prev = cur;
                if (node.left != null){
                    d.addLast(node.left);
                }
                if (node.right != null){
                    d.addLast(node.right);
                }
            }
            flag  = !flag;
        }
        return true;
    }
}
