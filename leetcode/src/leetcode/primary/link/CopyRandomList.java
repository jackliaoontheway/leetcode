package leetcode.primary.link;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {


    public static void main(String[] args) {

    }

    public Node3 copyRandomList(Node3 head) {

        return head;
    }

}

class Node3 {
    public int val;
    public Node3 next;
    public Node3 random;

    public Node3() {}

    public Node3(int _val,Node3 _next,Node3 _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};