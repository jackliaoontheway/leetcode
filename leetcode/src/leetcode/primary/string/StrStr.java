package leetcode.primary.string;

public class StrStr {
	public static void main(String[] args) {
		
		System.out.println(strStr("mississippi", "issipi"));

		String a = "a";
		String b = "";
		// 注意 这里输出0 不是-1
		System.out.println(a.indexOf(b));
		System.out.println(a.indexOf("a"));

		// haystack.indexOf(needle);
	}

	public static int strStr(String haystack, String needle) {
		if (haystack == null) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		if(needle.length() > haystack.length()) {
			return -1;
		}
		for (int i = 0; i < haystack.length(); i++) {
			char n = needle.charAt(0);
			if (haystack.charAt(i) == n) {
				int k = i + 1;
				int x = 0;
				for (int j = 1; j < needle.length(); j++) {
					// 这里之所以是 == 就return 是因为k到了haystack的最长,但是needle还没结束
					// 所以可以肯定 再往后走没有意义 haystack从i到最后 肯定没有needle长
					if(k == haystack.length()) {
						return -1;
					}
					if (haystack.charAt(k++) != needle.charAt(j)) {
						x = 1;
						break;
					}
				}
				if (x == 0) {
					return i;
				}
			}
		}
		return -1;
	}
}
