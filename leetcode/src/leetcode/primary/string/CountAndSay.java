package leetcode.primary.string;

/**
 *
 * https://leetcode-cn.com/submissions/detail/24463623/
 */
public class CountAndSay {

	public static void main(String[] args) {

		String str = countAndSay3(5);

		System.out.println(str);

	}

	public String countAndSay4(int n) {
		StringBuilder res = new StringBuilder();
		if (n == 1) {
			return "1";
		}
		String str = countAndSay(n - 1);
		int l = 0;
		while (l < str.length()) {
			int i = 1;
			while (i < str.length() - l) {
				if (str.charAt(l + i) != str.charAt(l)) {
					break;
				}
				i++;
			}
			res.append(i).append(str.charAt(l));

			l = l + i;
		}
		return res.toString();
	}

	/**
	 * 第三种解决方案
	 */
	private static String countAndSay3(int n) {
		if (n == 1) {
			return "1";
		}
		StringBuilder str = new StringBuilder();
		String number = countAndSay(n - 1);
		int i = 0;
		while (i < number.length()) {
			int count = 1;
			while (i < number.length() - 1) {
				if (number.charAt(i) == number.charAt(i + 1)) {
					count++;
					i++;
				} else {
					break;
				}
			}
			str.append(count).append(number.charAt(i));
			i++;
		}
		return str.toString();
	}

	/**
	 * 第二种解决方案
	 */
	private static String countAndSay2(int n) {
		return countAndSay2(n, "1");
	}

	private static String countAndSay2(int n, String number) {
		if (n == 1) {
			return number;
		}
		String result = "";
		int count = 1;
		char cur = number.charAt(0);
		for (int i = 1; i < number.length(); i++) {
			if (number.charAt(i) == cur) {
				count++;
			} else {
				result += (count + "" + cur);
				count = 1;
				cur = number.charAt(i);
			}
		}
		result += (count + "" + cur);
		return countAndSay2(n - 1, result);
	}

	/**
	 * 
	 * 第一种解决方案
	 */
	private static String countAndSay(int n) {
		String number = "1";
		if (n == 1) {
			return number;
		}
		for (int i = 1; i < n; i++) {
			String temps[] = getStr(number);
			String s = "";
			for (String str : temps) {
				if (str != null) {
					s += (str.length() + "" + str.substring(0, 1));
				}
			}
			number = s;
		}
		return number;
	}

	private static String[] getStr(String number) {
		String[] temps = new String[number.length()];
		int index = 0;
		if (number.length() == 1) {
			temps[index] = number;
			return temps;
		}

		String cur = number.charAt(0) + "";
		String temp = cur;
		for (int j = 1; j < number.length(); j++) {
			if (cur.equals(number.charAt(j) + "")) {
				temp += cur;
			} else {
				temps[index++] = temp;
				cur = number.charAt(j) + "";
				temp = cur;
			}
			if (j == number.length() - 1) {
				temps[index++] = temp;
			}
		}
		return temps;
	}

}
