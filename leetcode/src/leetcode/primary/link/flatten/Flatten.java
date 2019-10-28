package leetcode.primary.link.flatten;


import java.util.ArrayList;
import java.util.List;

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
        if(head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        process(list, head);
        Node result = new Node();
        result.prev = null;
        result.val = list.get(0).val;
        Node current = result;
        for(int i=1;i<list.size();i++) {
            current.next = list.get(i);
            list.get(i).prev = current;
            current = current.next;
        }
        return result;
    }

    private void process(List<Node> list, Node head) {
        while (head != null) {
            list.add(head);
            if (head.child != null) {
                process(list, head.child);
            }
            head.child = null;
            head = head.next;
        }
    }

}