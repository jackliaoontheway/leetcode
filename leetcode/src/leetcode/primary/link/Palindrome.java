package leetcode.primary.link;

/**
 * 回文链表
 */
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
		System.out.print(result);
	}

	public static ListNode reverseLink(ListNode prev,ListNode node1) {
        if(node1 == null) {
            return prev;
        }

        ListNode temp = node1.next;
        node1.next = prev;
        prev = node1;
        return reverseLink(prev,temp);
	}

	public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }

        ListNode newNodeHead = new ListNode(head.val);
        ListNode newCurrentNode = newNodeHead;

        ListNode temp = head.next;
        while (temp != null) {
            newCurrentNode.next = new ListNode(temp.val);
            newCurrentNode = newCurrentNode.next;
            temp = temp.next;
        }

        ListNode reversed = reverseLink(null,head);
        while (reversed != null && newNodeHead != null) {
            if(reversed.val != newNodeHead.val) {
                return false;
            }
            reversed = reversed.next;
            newNodeHead = newNodeHead.next;
        }
	    return true;
	}

    /**
     * 别人的解决方案
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while(fast != null && fast.next != null) {
            //反转前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null? slow.next : slow;
        while(p1 != null) {
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

}
