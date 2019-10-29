package leetcode.primary.link.flatten;


/**
 * 扁平化多级双向链表
 */
public class Flatten {

    public static void main(String[] args) {

        Node node13 = new Node(13,null,null,null);

        Node node11 = new Node(11,null,null,null);
        Node node12 = new Node(12,node11,null,node13);
        node11.next = node12;
        node12.prev = node11;

        Node node9 = new Node(9,null,null,node11);
        Node node10 = new Node(10,node9,null,null);
        node9.next = node10;
        node10.prev = node9;

        Node node5 = new Node(5,null,null,node9);
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

        new Flatten().flatten(node1);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public Node flatten(Node head) {
        process(head);
        return head;
    }

    private Node process(Node head) {
        if(head == null) {
            return null;
        }

        Node next = null;
        Node child = head.child;
        if(child != null) {
            next = head.next;
            head.next = child;
            child.prev = head;
            head.child = null;
            head = child;
        }

        while (head != null) {
            if (head.child != null) {
                Node lastOne = process(head);
                head = lastOne;
            }

            if(head.next == null) {
                if(next != null) {
                    head.next = next;
                    next.prev = head;
                    head = next;
                    next = null;
                    continue;
                }
                break;
            }
            head = head.next;
        }
        return head;
    }

}