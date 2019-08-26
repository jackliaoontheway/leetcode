package leetcode.primary.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class MyQueueStack {

    private Queue<Integer> queue;

    public static void main(String[] args) {
        MyQueueStack obj = new MyQueueStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueueStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.offer(x);
        while (!this.queue.isEmpty()) {
            temp.add(this.queue.poll());
        }
        this.queue = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return this.queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.queue.isEmpty();
    }

}
