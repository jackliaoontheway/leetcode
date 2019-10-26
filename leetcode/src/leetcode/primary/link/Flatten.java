package leetcode.primary.link;

/**
 * 扁平化多级双向链表
 */
public class Flatten {

    public static void main(String[] args) {

    }

    public Node flatten(Node head) {

        return head;
    }

}


class Nodex {
    public int val;
    public Nodex prev;
    public Nodex next;
    public Nodex child;

    public Nodex() {}

    public Nodex(int _val,Nodex _prev,Nodex _next,Nodex _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};