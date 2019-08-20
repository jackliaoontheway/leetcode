package leetcode.primary.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
 * 最小栈
 */
public class MinStack2 {

    public static void main(String[] args) {
        MinStack2 obj = new MinStack2();
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

    public MinStack2() {
        this.data = new Stack<>();
        this.minimalStack = new Stack<>();
    }

    public void push(int x) {
        this.data.push(x);
        // 这里的判断很关键, 不同步
        if (this.minimalStack.isEmpty() || this.minimalStack.peek() >= x) {
            this.minimalStack.push(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            // 这里的判断很关键 一定要用equals 为什么不能用 == 因为Integer是个引用
            // push 为什么可以用 >= 因为Integer 作出了拆箱处理
            if(this.data.peek().equals(this.minimalStack.peek())) {
                this.minimalStack.pop();
            }
            this.data.pop();
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
