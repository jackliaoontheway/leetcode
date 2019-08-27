package leetcode.primary.stack;

import java.util.Stack;

/**
 * 字符串解码
 * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 */
public class DecodeString {


    public static void main(String[] args) {

        System.out.print(decodeString("2[abc]10[cd]ef"));
    }


    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String temp = "";
                String top = stack.pop();
                while (!top.equals("[")) {
                    temp = top + temp;
                    top = stack.pop();
                }

                String times = stack.pop();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    times = stack.pop() + times;
                }

                int t = Integer.parseInt(times);

                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < t; j++) {
                    stringBuffer.append(temp);
                }

                stack.push(stringBuffer.toString());
            }
            else {
                stack.push(s.charAt(i) + "");
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

}

