package leetcode.primary.queue;

/**
 * https://leetcode-cn.com/submissions/detail/25952541/
 * 设计循环队列
 */
public class MyCircularQueue2 {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue2(int k) {
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            this.head = 0;
        }

        this.tail = (tail + 1) % size;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }

        this.head = (head + 1) % size;

        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return (head == -1);
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail+ + 1) % size == head;
    }


}
