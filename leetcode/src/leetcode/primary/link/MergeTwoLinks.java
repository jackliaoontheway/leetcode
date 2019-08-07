package leetcode.primary.link;

/**
 * 合并两个有序链表
 */
public class MergeTwoLinks {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);
		ListNode node8 = new ListNode(10);
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		node1 = mergeTwoLists(node1, node5);

		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}

	/**
	 * 方案一
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode header = l1;
		ListNode prev = null;
		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				ListNode temp = l2.next;

				if (prev != null) {
					prev.next = l2;
				} else {
					header = l2;
				}
				prev = l2;
				l2.next = l1;
				l2 = temp;
			} else {
				prev = l1;
				l1 = l1.next;
			}
		}
		if (l1 == null) {
			prev.next = l2;
		}

		return header;
	}

	/**
	 * 方案二 使用递归
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l2.next, l1);
			return l2;
		}
	}
}
