package leetcode.primary.stack;

public class MyStack {

    private Integer[] data;
    private int size;
    private int head;

    public MyStack(int size) {
        this.data = new Integer[size];
        this.size = size;
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == size - 1;
    }

    public boolean push(int item) {
        if (isFull()) {
            return false;
        }
        head = head + 1;
        data[head] = item;
        return true;
    }

    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data[head] = null;
        head = head - 1;
        return true;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

}
