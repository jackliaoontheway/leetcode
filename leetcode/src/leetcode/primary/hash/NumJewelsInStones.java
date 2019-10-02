package leetcode.primary.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 宝石与石头
 * https://leetcode-cn.com/submissions/detail/31852527/
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        System.out.print(new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, l = J.length(); i < l; i++) {
            map.put(String.valueOf(J.charAt(i)), 0);
        }

        for (int i = 0, l = S.length(); i < l; i++) {
            String key = String.valueOf(S.charAt(i));
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
        }

        int result = 0;
        for (int count : map.values()) {
            result += count;
        }
        return result;
    }

}
