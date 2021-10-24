/**
 * 删除排序链表中的重复元素
 * 7-20
 * 递归
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 */


class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //1：这种情况不可能有相同节点，直接返回
        if (head ==null && head.next==null){
            return head;
        }
        //2：当前节点与下个节点一样
        if (head.val == head.next.val){
            //跳过当前节点的下个节点，指向递下下个归的结果
            head.next = deleteDuplicates(head.next.next);
            //继续递归
            return deleteDuplicates(head);
        }
        //当前节点与下个节点不同，递归下个节点
        deleteDuplicates(head.next);
        return head;
    }
}

