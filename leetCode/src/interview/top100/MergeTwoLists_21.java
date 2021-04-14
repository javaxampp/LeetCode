package interview.top100;

import data.structrue.ListNode;

public class MergeTwoLists_21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsByLoop(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 != null){
            node.next = l1;
        }
        if(l2 != null){
            node.next = l2;
        }
        return dummy.next;
    }

    public ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursive(l1, l2.next);
            return l2;
        }
    }
}
