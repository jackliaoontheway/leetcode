package leetcode.primary.stack;

import java.util.Stack;

/**
 * 每日温度
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        int[] result = dailyTemperatures3(temperatures);

        for (int x : result) {
            System.out.print(x);
        }
    }

    /**
     * 第一种解决方案
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 第二种解决方案
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 第三种解决方案
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures3(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return result;
    }

}
