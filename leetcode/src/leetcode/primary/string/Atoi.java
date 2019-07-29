package leetcode.primary.string;

import java.math.BigInteger;

/**
 * 字符串转换整数 (atoi)
 * 
 * https://leetcode-cn.com/submissions/detail/24222393/
 */
public class Atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}

	public static int myAtoi(String str) {

		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		char firstLetter = str.charAt(0);

		if (firstLetter == '-' || firstLetter == '+' || Character.isDigit(firstLetter)) {
			boolean isNegative = false;
			if (firstLetter == '-') {
				isNegative = true;
				str = str.substring(1);
			} else if (firstLetter == '+') {
				str = str.substring(1);
			}
			if (str.length() == 0) {
				return 0;
			}
			String numbers = "";
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isDigit(c)) {
					numbers += c;
				} else {
					break;
				}
			}
			if (numbers.length() == 0) {
				return 0;
			}

			BigInteger num = new BigInteger(numbers);
			BigInteger max = new BigInteger(Integer.MAX_VALUE + "");
			if (num.compareTo(max) > 0) {
				if (isNegative) {
					return Integer.MIN_VALUE;
				}
				return Integer.MAX_VALUE;
			}

			if (isNegative) {
				return num.intValue() * -1;
			}

			return num.intValue();
		}

		return 0;

	}

}
