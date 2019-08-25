package leetcode.primary.stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * 遇到 + - * / 则将前面的两个值从stack pop 出来 else 则push入栈
 */
public class EvalRPN {

    public static void main(String[] args) {
        String x[] = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.print(evalRPN2(x));
    }

    public static int evalRPN(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (String s : args) {
            switch (s) {
                case "+":
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    /**
     * 优化 重复代码
     */
    public static int evalRPN2(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(args[0]));
        stack.push(Integer.parseInt(args[1]));
        for (int i = 2; i < args.length; i++) {
            Integer right = null;
            Integer left = null;
            if(stack.size() > 0) {
                right = stack.pop();
            }
            if(stack.size() > 0) {
                left = stack.pop();
            }
            String s = args[i];
            switch (s) {
                case "+":
                    stack.push(left + right);
                    break;
                case "-":
                    stack.push(left - right);
                    break;
                case "*":
                    stack.push(left * right);
                    break;
                case "/":
                    stack.push(left / right);
                    break;
                default:
                    if(left != null) {
                        stack.push(left);
                    }
                    if(right != null) {
                        stack.push(right);
                    }
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

}
