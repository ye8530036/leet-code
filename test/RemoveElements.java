/**
 * 移除链表元素
 * 9-15
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 思路：递归
 * 逐一检测所有的节点，与val对比
 */
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
