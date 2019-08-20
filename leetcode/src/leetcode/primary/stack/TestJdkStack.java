package leetcode.primary.stack;

import java.util.Stack;

public class TestJdkStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer item = stack.pop();
        System.out.println(item);
        System.out.println(stack.size());

        stack.peek();
    }

}
