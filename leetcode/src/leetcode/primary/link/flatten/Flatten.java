package leetcode.primary.link.flatten;


/**
 * 扁平化多级双向链表
 */
public class Flatten {

    public static void main(String[] args) {

        Node node5 = new Node(5,null,null,null);
        Node node6 = new Node(6,null,null,null);
        Node node7 = new Node(7,null,null,null);
        Node node8 = new Node(8,null,null,null);;
        node5.next = node6;
        node6.next = node7;
        node6.prev = node5;
        node7.next = node8;
        node7.prev = node6;
        node8.prev = node7;

        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, node1, null, node5);
        node1.next = node2;
        Node node3 = new Node(3, node2, null, null);
        node2.next = node3;
        Node node4 = new Node(4,node3,null,null);
        node3.next = node4;

        node1 = new Flatten().flatten(node1);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public Node flatten(Node head) {

        process(null, head);

        return head;
    }

    private void process(Node result, Node head) {
        Node current = head;
        while (current != null) {
            if (result == null) {
                result = head;
            } else {
                result.next = head;
                head.prev = result;
            }
            if (head.child != null) {
                process(head, head.child);
            }
            head.child = null;
            head = head.next;
        }
    }

}