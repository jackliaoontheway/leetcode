package leetcode.primary.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 */
public class Anagram {

	public static void main(String[] args) {
		String s = "hhby", t = "bhhy";
		System.out.println(isAnagram3(s, t));
	}

	/**
	 * 第一种解决方案 使用 Arrays.sort 先排序
	 * 
	 */
	private static boolean isAnagram(String s, String t) {
		char[] chars0 = s.toCharArray();
		char[] chars1 = t.toCharArray();
		Arrays.sort(chars0);
		Arrays.sort(chars1);

		return Arrays.equals(chars0, chars1);
		/*
		 * s = new String(chars0); t = new String(chars1); return s.equals(t);
		 */
	}

	public static boolean isAnagram3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			count = (count == null ? 1 : count + 1);
			map.put(s.charAt(i), count);

			count = map.get(t.charAt(i));
			count = (count == null ? -1 : count - 1);
			map.put(t.charAt(i), count);
		}
		
		for(int x : map.values()) {
			if(x != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 最佳解决方案 https://leetcode-cn.com/submissions/detail/23970978/
	 */
	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int has[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			has[s.charAt(i) - 'a']++;
			has[t.charAt(i) - 'a']--;
		}
		for (int i : has)
			if (i != 0)
				return false;
		return true;
	}
}
