package leetcode.primary.link;

public class Palindrome {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		boolean result = isPalindrome(node1);
	}

	public static boolean isPalindrome(ListNode head) {
		return false;
	}
}
