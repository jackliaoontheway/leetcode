package leetcode.primary.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "f", "f", "" }));
	}

	public static String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String pre = strs[0];
		label: for (int i = 1; i < strs.length; i++) {
			// 这里的 indexOf 用的很巧妙
			while (strs[i].indexOf(pre) != 0) {
				// substring 用的好
				pre = pre.substring(0, pre.length() - 1);
				if (pre == "") {
					break label;
					// return "";
				}
			}
		}
		return pre;
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
