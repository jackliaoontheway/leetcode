package leetcode.primary.string;

/**
 * 翻转字符串里的单词
 * https://leetcode-cn.com/submissions/detail/30527292/
 */
public class ReverseWords {

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
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() == 0) {
                continue;
            }
            stringBuffer.append(strings[i]);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

}
