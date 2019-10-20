package leetcode.primary.link;

/**
 * 奇偶链表
 * https://leetcode-cn.com/submissions/detail/33701762/
 */
public class OddEvenList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1 = new OddEvenList().oddEvenList(node1);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    /**
     * 第一种解决方案
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode current = head;
        while(current != null) {
            ListNode tempx = current;
            current = current.next;

            if(tempx.next != null) {
                tempx.next = tempx.next.next;
            }
        }

        ListNode fNode = head;
        while(fNode != null) {
            if(fNode.next == null) {
                fNode.next = temp;
                break;
            }
            fNode = fNode.next;
        }

        return head;
    }
}
