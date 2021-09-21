/**
 * 反转链表
 * 9-20
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 思路：迭代
 * 从前往后逐一检测所有的节点将之放入一个链表中
 * 将再将指针从后往前从链表中取出，形成一个新的链表
 */

class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}