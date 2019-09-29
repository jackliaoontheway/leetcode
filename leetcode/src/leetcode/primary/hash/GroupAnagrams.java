package leetcode.primary.hash;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/submissions/detail/31611595/
 */
public class GroupAnagrams {


    public static void main(String[] args) {


        List<List<String>> result = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            List<String> tempList = map.get(String.valueOf(charArray));
            if (tempList == null) {
                tempList = new ArrayList<>();
                map.put(String.valueOf(charArray), tempList);
            }
            tempList.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
