package leetcode.primary.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * https://leetcode-cn.com/submissions/detail/31435224/
 */
public class Isomorphic {

    public static void main(String[] args) {
        System.out.print(new Isomorphic().isIsomorphic2("abcd", "aaaa"));
    }

    /**
     * 解决方案一
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<String, String> map0 = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map0.put(s.substring(i, i + 1), t.substring(i, i + 1));
            map1.put(t.substring(i, i + 1), s.substring(i, i + 1));
        }
        String result0 = "";
        String result1 = "";
        for (int i = 0; i < s.length(); i++) {
            result0 += map0.get(s.substring(i, i + 1));
            result1 += map1.get(t.substring(i, i + 1));
        }
        return result0.equals(t) && result1.equals(s);
    }

    /**
     * 解决方案二
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.substring(i, i + 1)) == null) {
                if(map.containsValue(t.substring(i, i + 1))) {
                    return false;
                }
                map.put(s.substring(i, i + 1), t.substring(i, i + 1));
            } else {
                if (!map.get(s.substring(i, i + 1)).equals(t.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
