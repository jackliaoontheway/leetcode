package leetcode.primary.queue;

/**
 * https://leetcode-cn.com/submissions/detail/25952541/
 * 设计循环队列
 */
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(head == -1) {
            head = 0;
        }
        tail ++;
        if(tail == data.length) {
            tail = 0;
        }
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        if(head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head ++;
        if(head == data.length) {
            head = 0;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(head != -1) {
            return this.data[head];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(tail != -1) {
            return this.data[tail];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head == -1 && tail == -1) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(tail > head) {
            return (this.tail - this.head == (this.data.length - 1));
        }
        if(tail < head) {
            return head - tail == 1;
        }
        return false;
    }


}
