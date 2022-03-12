/**
 * 题目：N叉树的后序遍历
 * 时间：3-12
 * 算法：递归
 */



import java.util.ArrayList;
import java.util.List;

class Postorder_NTraversal_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Postorder(root,res);
        return res;
    }
    //主递归程序
    public void Postorder (Node root,List<Integer> res){
        if (root == null){
            return ;
        }
      for (Node ch : root.children){
          Postorder(ch,res);
      }
      res.add(root.val);
    }
}
