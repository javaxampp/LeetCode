package interview.tag.dfs;

import java.util.ArrayList;

import data.structrue.ListNode;
import data.structrue.TreeNode;

/**
* 
*/
public class SortedListToBST_109 {
	/**
	错误示范1：链表是有序的，第一个值，肯定不是根节点，得是中间的那个值
	*/
	public TreeNode sortedListToBST_false01(ListNode head) {
		if(head == null) {
			return null;
		}
		TreeNode root = new TreeNode(head.val);
		if(head.next == null) {
			return root;
		}
		root.left = sortedListToBST_false01(head.next);
		head = head.next;
		root.right = sortedListToBST_false01(head.next);
		return root;
	}
	
	/**
	根据上一个错误示范，需要找到链表中间的那个值，作为树的根节点，故想法将链表转为数组进行找到中间的节点
	*/
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode node = head;
		ArrayList<ListNode> list = new ArrayList<>();
		while(node != null) {
			list.add(head);
			head = head.next;
		}
		int size = list.size();
		int rootIndex = size/2;
		return null;
	}
}
