package leetcode.primary.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 宝石与石头
 */
public class NumJewelsInStones {


    public static void main(String[] args) {
        System.out.print(new NumJewelsInStones().numJewelsInStones("aA","aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0, l = J.length(); i < l; i++) {
            set.add(String.valueOf(J.charAt(i)));
        }

        int result = 0;
        for (int i = 0, l = S.length(); i < l; i++) {
            if (set.contains(String.valueOf(S.charAt(i)))) {
                result ++;
            }
        }
        return result;
    }

}
