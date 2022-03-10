/**
 * 题目：二叉树的前序遍历
 * 时间：3-10
 * 算法：前序遍历
 */




import java.util.ArrayList;
import java.util.List;

class N_Tree_PreorderTraversal_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        preorders(root,res);
        return res;
    }
    //主递归方法
    public void preorders(Node root,List<Integer> res){
        if (root == null){
            return ;
        }
        //加入头结点
        res.add(root.val);
        //循环遍历子节点
       for (Node roots :root.children){
           preorders(roots,res);
       }
    }
}
