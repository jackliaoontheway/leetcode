package leetcode.primary.string;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "f", "f", "" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		String result = "";
		if (strs == null || strs.length == 0) {
			return result;
		}
		int i = 0;
		label: while (true) {
			Set<String> set = new HashSet<>();
			for (String s : strs) {
				if (s.length() > i) {
					set.add(s.charAt(i) + "");
				} else {
					break label;
				}
			}
			if (set.size() > 1) {
				break;
			}
			result += set.iterator().next();
			i++;
		}
		return result;
	}

}
