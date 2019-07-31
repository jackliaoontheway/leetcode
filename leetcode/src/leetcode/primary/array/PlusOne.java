package leetcode.primary.array;

/**
 * 加一
 * 
 * @author user
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 8, 9, 9, 9 };
		digits = plusOne2(digits);
		for (int x : digits) {
			System.out.println(x);
		}
	}

	public static int[] plusOne2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = (digits[i] + 1) % 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
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
