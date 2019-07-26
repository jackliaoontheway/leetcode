package leetcode.primary.string;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 */
public class Anagram {

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
	
	/**
	 * 第一种解决方案 使用 Arrays.sort 先排序
	 * 
	 * https://leetcode-cn.com/submissions/detail/23970978/
	 */
	private static boolean isAnagram(String s, String t) {
		char[] chars0 = s.toCharArray();
		char[] chars1 = t.toCharArray();
		Arrays.sort(chars0);
		Arrays.sort(chars1);
		s = new String(chars0);
		t = new String(chars1);
		return s.equals(t);
	}
}
