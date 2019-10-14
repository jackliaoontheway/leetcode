package leetcode.primary.link;

/**
 * MyLinkedList
 */
public class MyLinkedList {

    private int size;
    private Node head;

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtIndex(1, 2);
        System.out.print(obj.get(1));
        System.out.print(obj.get(0));
        System.out.print(obj.get(2));
    }


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node temp = this.head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (this.size == 0) {
            addAtHead(val);
            return;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if(index <= 0) {
            this.addAtHead(val);
            return;
        }
        if(index == this.size) {
            this.addAtTail(val);
            return;
        }

        Node temp = this.head;
        Node prev = null;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                Node newNode = new Node(val);
                newNode.next = temp;
                if (prev == null) {
                    this.head = newNode;
                } else {
                    prev.next = newNode;
                }
                this.size++;
                return;
            }
            i++;
            prev = temp;
            temp = temp.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (this.size <= index) {
            return;
        }
        Node temp = this.head;
        Node prev = null;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                if (prev == null) {
                    this.head = this.head.next;
                } else {
                    prev.next = temp.next;
                }
                this.size --;
                return;
            }
            i++;
            prev = temp;
            temp = temp.next;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}