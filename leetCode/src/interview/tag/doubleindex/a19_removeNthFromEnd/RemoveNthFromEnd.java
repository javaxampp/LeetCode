package interview.tag.doubleindex.a19_removeNthFromEnd;

import data.structrue.ListNode;

import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
//      最需要考虑的就是，如果删除的是头节点，则需要提前将其保存
        if (head == null || n < 1) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
//        fast先走n步
        while (n > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
//        如果fast==null，则说明删除的是头节点
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 增加一个头节点，可以少一个判断删除头节点的特殊情况
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
//        因为增加了一个头节点，所以fast需要先走n+1步
        while (n >= 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
