package leetcode.primary.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);


        System.out.print(new DetectCycle().detectCycle(node1));
    }

    /**
     * 第一种解决方案 使用 Set
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 第二种方案 使用 链表， 双指针，存在疑问
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode lower = head;
        ListNode faster = head.next;
        ListNode result = head;
        while (lower != faster) {
            if (faster == null || faster.next == null) {
                return null;
            }
            lower = lower.next;
            result = faster.next;
            faster = faster.next.next;
        }
        return result;
    }
}
