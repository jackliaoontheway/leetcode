package leetcode.primary.link.rotateRight;

/**
 * 旋转链表
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1 = new RotateRight().rotateRight(node1, 21);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        int rotate = k % size;
        if(rotate == 0) {
            return head;
        }

        for (int i = 0; i < rotate; i++) {
            ListNode current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next.next = head;
            head = current.next;
            current.next = null;
        }
        return head;
    }
}
