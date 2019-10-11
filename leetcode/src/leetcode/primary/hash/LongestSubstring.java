package leetcode.primary.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.print(new LongestSubstring().lengthOfLongestSubstring("abcabc"));
    }

    /**
     * 第一种解决方案 使用 hashmap 和 set
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        for (int i = 0, len = s.length(); i < len; i++) {
            if (set.contains(s.charAt(i))) {
                if (set.size() > maxLength) {
                    maxLength = set.size();
                }
                set.clear();
                i = map.get(s.charAt(i)) + 1;
            }
            set.add(s.charAt(i));
            map.put(s.charAt(i),i);
        }
        return (set.size() > maxLength ? set.size() : maxLength);
    }

}
