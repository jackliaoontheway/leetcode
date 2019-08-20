package leetcode.primary.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
 * 最小栈
 */
public class MinStack1 {

    public static void main(String[] args) {
        MinStack1 obj = new MinStack1();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.print(obj.getMin());
        obj.pop();
        System.out.print(obj.getMin());
        obj.pop();
        System.out.print(obj.getMin());

    }

    private Stack<Integer> data;
    private Stack<Integer> minimalStack;

    public MinStack1() {
        this.data = new Stack<>();
        this.minimalStack = new Stack<>();
    }

    public void push(int x) {
        this.data.push(x);
        // 这里的判断很关键
        if (this.minimalStack.isEmpty() || this.minimalStack.peek() > x) {
            this.minimalStack.push(x);
        } else {
            // 为了同步 pop 所以 copy一个 minimal item
            this.minimalStack.push(this.minimalStack.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            this.data.pop();
            this.minimalStack.pop();
        }
    }

    public int top() {
        if (data.isEmpty()) {
            return -1;
        }
        return this.data.peek();
    }

    public int getMin() {
        if (this.minimalStack.isEmpty()) {
            return -1;
        }
        return this.minimalStack.peek();
    }

}
