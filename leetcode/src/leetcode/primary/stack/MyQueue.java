package leetcode.primary.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack;

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.print(obj.peek());
        System.out.print(obj.pop());
        System.out.print(obj.empty());
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.stack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        // 出栈 入栈
        while (!this.stack.isEmpty()) {
            temp.push(this.stack.pop());
        }
        //入栈
        temp.push(x);
        while (!temp.isEmpty()) {
            this.stack.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return this.stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return this.stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }

}
