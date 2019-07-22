package leetcode.primary.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqueString {
	public static void main(String[] args) {
		String s = "aadadaad";
		int index = find1(s);
		System.out.println(index);
	}

	/**
	 * 第一种解决方案 使用HashMap 然后for循环
	 */
	private static int find0(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer times = map.get(c);
			times = (times == null ? 0 : times);
			map.put(c, ++times);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer times = map.get(c);
			if (times == 1) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 第二种解决方案 使用LinkedHashMap
	 * has error
	 * https://leetcode-cn.com/submissions/detail/23561163/
	 * @return
	 */
	private static int find1(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer index = map.get(c);
			if (index != null) {
				map.remove(c);
			} else {
				map.put(c, i);
			}
		}
		Collection<Integer> collections = map.values();
		if (collections.size() > 0) {
			return collections.iterator().next();
		}
		return -1;
	}
	
	public int firstUniqChar(String s) {
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int startIndex = s.indexOf(ch);
            if (startIndex != -1 && startIndex == s.lastIndexOf(ch)) {
                index = (index == -1 || index > startIndex) ? startIndex : index;
            }
        }
        return index;
    }
}
