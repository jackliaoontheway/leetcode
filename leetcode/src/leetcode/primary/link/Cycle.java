package leetcode.primary.link;

import java.util.HashSet;
import java.util.Set;

public class Cycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.print(hasCycle(node1));
    }

    /**
     * 使用Set
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            if(set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 使用双指针
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



}
