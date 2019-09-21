package leetcode.primary.string;

/**
 * 反转字符串中的单词 III
 * https://leetcode-cn.com/submissions/detail/30619918/
 */
public class ReverseWords2 {

    public static void main(String[] args) {
        System.out.print(reverseWords("the  sky is blue"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0) {
                continue;
            }
            stringBuffer.append(reverseString(strings[i]));
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

    private static char[] reverseString(String string) {
        char[] result = string.toCharArray();
        int head = 0;
        int tail = result.length - 1;
        while (head < tail) {
            char temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
            head++;
            tail--;
        }
        return result;
    }

}
