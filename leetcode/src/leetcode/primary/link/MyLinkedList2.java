package leetcode.primary.link;

/**
 * 设计双向链表
 */
public class MyLinkedList2 {

    public static void main(String[] args) {
        MyLinkedList2 obj = new MyLinkedList2();
        obj.addAtHead(5);
        obj.deleteAtIndex(0);
        System.out.print(obj.get(0));
        System.out.print(obj.get(1));
        System.out.print(obj.get(2));
    }

    /**
     * Initialize your data structure here.
     */

    Node2 head = null;
    Node2 tail = null;
    int size = 0;

    public MyLinkedList2() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (size == 0 || index >= size) {
            return -1;
        }
        Node2 current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.val;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {

        Node2 newNode = new Node2(val);
        if (this.size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node2 newNode = new Node2(val);
        if (this.size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index <= 0) {
            this.addAtHead(val);
            return;
        }
        if (index == this.size) {
            this.addAtTail(val);
            return;
        }

        Node2 current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                Node2 newNode = new Node2(val);
                current.prev.next = newNode;
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev = newNode;
                this.size++;
                break;
            }
            i++;
            current = current.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (this.size <= index) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            if(this.head != null) {
                this.head.prev = null;
            }
            this.size--;
            return;
        }
        if (index == this.size - 1) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return;
        }

        Node2 current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                this.size--;
                break;
            }
            i++;
            current = current.next;
        }
    }
}

class Node2 {
    int val;
    Node2 next;
    Node2 prev;

    public Node2(int val) {
        this.val = val;
    }
}
