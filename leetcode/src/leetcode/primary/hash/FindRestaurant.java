package leetcode.primary.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个列表的最小索引总和
 * https://leetcode-cn.com/submissions/detail/31379406/
 */
public class FindRestaurant {

    public static void main(String[] args) {
        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = {"KFC", "Shogun", "Burger King"};
        String[] result = new FindRestaurant().findRestaurant(s1, s2);
        for (String s : result) {
            System.out.print(s);
        }
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int min = -1;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int l = map.get(list2[i]);
                if (min == -1) {
                    min = l + i;
                    result.add(list2[i]);
                } else {
                    if (l + i == min) {
                        result.add(list2[i]);
                    } else if (l + i < min) {
                        min = l + i;
                        result.clear();
                        result.add(list2[i]);
                    }
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
