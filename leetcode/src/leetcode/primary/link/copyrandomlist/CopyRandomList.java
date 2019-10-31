package leetcode.primary.link.copyrandomlist;


import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {


    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        node1.next = node2;
        node2.random = node2;
        node1.random = node2;


        node1 = new CopyRandomList().copyRandomList(node1);


        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public Node copyRandomList(Node head) {
        Map<String, Node> map = new HashMap<>();
        return copyRandomList(map, head);
    }

    public Node copyRandomList(Map<String, Node> map, Node head) {
        if (head == null) {
            return null;
        }

        Node existedNode = map.get(head.toString());
        if(existedNode == null) {
            existedNode = new Node();
            existedNode.val = head.val;

            map.put(head.toString(),existedNode);

            existedNode.next = copyRandomList(map,head.next);
            existedNode.random = copyRandomList(map,head.random);
        }
        return existedNode;
    }

}
