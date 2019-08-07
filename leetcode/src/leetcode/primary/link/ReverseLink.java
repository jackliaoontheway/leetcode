package leetcode.primary.link;

/**
 * 反转链表
 */
public class ReverseLink {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node1 = reverseList(null, node1);

		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}

	/**
	 * 第一种解决方案
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	/**
	 * 第二种解决方案
	 */
	private static ListNode reverseList(ListNode prev, ListNode current) {
		if (current == null) {
			return prev;
		}
		ListNode temp = current.next;
		current.next = prev;
		prev = current;
		current = temp;
		return reverseList(prev, current);
	}
}
