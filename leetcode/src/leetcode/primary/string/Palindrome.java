package leetcode.primary.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 验证回文串 https://leetcode-cn.com/submissions/detail/24143401/
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(".,"));
	}

	public static boolean isPalindrome2(String s) {

		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}

		int i = 0;
		int x = s.length() - 1;
		while (i < x) {
			char c = s.charAt(i);
			char t = s.charAt(x);
			if (Character.isLetterOrDigit(c) && Character.isLetterOrDigit(t)) {
				if (Character.toLowerCase(c) == Character.toLowerCase(t)) {
					i++;
					x--;
				} else {
					return false;
				}
			} else {
				if (!Character.isLetterOrDigit(c)) {
					i++;
				}
				if (!Character.isLetterOrDigit(t)) {
					x--;
				}
			}
		}
		return true;
	}

	public static boolean isPalindrome(String s) {

		Set<String> set = new HashSet<String>();
		for (char i = 'a'; i <= 'z'; i++) {
			set.add(i + "");
		}
		for (int i = 0; i <= 9; i++) {
			set.add(i + "");
		}

		String x = "";
		String y = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			String c = s.charAt(i) + "";
			if (set.contains(c.toLowerCase())) {
				x += c;
			}

			String t = s.charAt(s.length() - 1 - i) + "";
			if (set.contains(t.toLowerCase())) {
				y += t;
			}
		}
		return x.equalsIgnoreCase(y);
	}

}
