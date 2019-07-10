package leetcode.primary;

/**
 * 加一
 * 
 * @author user
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 4, 0, 9 };
		plusOne(digits);
		for (int x : digits) {
			System.out.println(x);
		}
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0)
				return digits;
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
