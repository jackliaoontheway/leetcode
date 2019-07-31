package leetcode.primary.array;

/**
 * 加一
 * 
 * @author user
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 8, 9, 9, 9 };
		digits = plusOne3(digits);
		for (int x : digits) {
			System.out.println(x);
		}
	}

	public static int[] plusOne3(int[] digits) {
		String s = "";
		for (int i = 0; i < digits.length; i++) {
			s += digits[i];
		}
		Long l = Long.parseLong(s);
		l += 1;

		String x = l + "";

		digits = new int[x.length()];

		for (int i = 0; i < x.length(); i++) {
			digits[i] = Integer.parseInt(x.charAt(i) + "");
		}

		return digits;
	}

	public static int[] plusOne2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			// 除了10 取余 等于0 之外 其他数%10 都等于本身
			digits[i] = (digits[i] + 1) % 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
		// 如果能执行到这里 说明数组里面的没一个元素加一之后 % 10 都等于0 说明都是 9
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	private static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] % 10 != 0) {
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

}
