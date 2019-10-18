package leetcode.primary.link;

/**
 * 移除链表元素
 * https://leetcode-cn.com/submissions/detail/33551931/
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1 = new RemoveElements().removeElements(node1, 1);

        System.out.println(node1);
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (currentNode.val == val) {
                if (prevNode != null) {
                    prevNode.next = currentNode.next;
                } else {
                    head = head.next;
                }
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        return head;
    }


    /**
     * 其他解决方案
     * @param head
     * @param val
     * @return
     */
    public  ListNode removeElements2(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }
}
