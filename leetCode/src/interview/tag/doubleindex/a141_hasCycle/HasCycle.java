package interview.tag.doubleindex.a141_hasCycle;

import data.structrue.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class HasCycle {
    /**
     *
    */
    public boolean hasCycle(ListNode head) {
        if (head == null ) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null ) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
//            链表没环时候，这样会导致 fast.next == null，下一次循环，slow==fast，返回true
//            if (fast.next != null) {
//                fast = fast.next.next;
//            }
//
//            正确做法是，一步步的执行，而不是跨一步，并且当fast = fast.next执行后，fast==null，就直接返回false，节省循环次数
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }
        return false;
    }
}
