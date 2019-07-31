package leetcode.primary.string;

/**
 * 报数
 *
 * https://leetcode-cn.com/submissions/detail/24463623/
 */
public class CountAndSay {

	public static void main(String[] args) {

		String str = countAndSay(4);

		System.out.println(str);

	}

	/**
	 * 
	 * 第一种解决方案
	 */
	private static String countAndSay(int n) {
		String number = "1";
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
