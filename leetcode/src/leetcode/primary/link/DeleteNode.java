package leetcode.primary.link;

/**
 * 删除链表中的节点
 */
public class DeleteNode {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		deleteNode(node1);

		System.out.println(node1);
	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
