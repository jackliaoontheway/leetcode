package leetcode.primary.link;

/**
 * 删除链表的倒数第N个节点
 *
 */
public class RemoveNthFromEnd {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		removeNthFromEnd(node1, 4);

		System.out.println(node1);
	}

	/**
	 * 第一种解决方案
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		if (head.next == null && n == 1) {
			return null;
		}

		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		int count = len - n;
		
		if(count == 0) {
			return head.next;
		}
		
		ListNode result = head;
		for (int i = 1; i < count; i++) {
			result = result.next;
		}
		
		if(n == 1) {
			result.next = null;
		} else {
			result.next = result.next.next;
		}
		return head;
	}

}
