/**
 * 合并两个有序链表
 * 7-2
 */

class Merge_Two_Sorted_Lists {
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;

        if (l2==null) return l1;

       if (l1.val<l2.val) {
           l1.next = mergeTwoLists(l1.next,l2);//递归调用
           return l1;
       }else {
           l2.next = mergeTwoLists(l1,l2.next);//递归调用
           return l2;
       }
    }

   public static class ListNode {
       int val;
       ListNode next;   // 下一个链表对象
       ListNode(int x) { val = x; }  //赋值链表的值
   }
}
