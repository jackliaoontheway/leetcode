package leetcode.primary.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckExpression {

    public static void main(String[] args) {
        CheckExpression check = new CheckExpression();
        boolean x = check.isValid("([{])");
        System.out.println(x);
    }

    Map<Character, Character> expressionMap = new HashMap<>();

    private void initExpressionMap() {
        expressionMap.put(')', '(');
        expressionMap.put('}', '{');
        expressionMap.put(']', '[');
    }

    Stack<Character> stack = new Stack<>();

    /**
     * 思路是 如果是 ( [ { 就入栈 , 如果遇到 ) ] } 就要判断是否和head匹配 如果不匹配则错误 如果匹配则出栈
     * 最后判断栈是否为空
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }

        initExpressionMap();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            // 如果不是expressionMap的key和value 就 return false
            if (!(expressionMap.containsKey(ch) || expressionMap.containsValue(ch))) {
                return false;
            }
            // 如果是 (,[,{ 则push 入栈
            if (expressionMap.containsValue(ch)) {
                stack.push(ch);
                continue;
            }
            // 如果stack是空,但是是),},] 则return false
            if (stack.isEmpty()) {
                return false;
            }
            Character head = stack.peek();
            // 如果不匹配 则 return false
            if (!head.equals(expressionMap.get(ch))) {
                return false;
            }
            // 到这里就是匹配了 出栈
            stack.pop();
        }
        return stack.isEmpty();
    }


}
