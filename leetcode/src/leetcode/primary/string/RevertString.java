package leetcode.primary.string;

public class RevertString {

	public static void main(String[] args) {

		char[] strings = { 'h', 'e', 'l', 'l', 'o' };
		revert(strings);
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + ",");
		}
	}

	/**
	 * 我的解决方案
	 * 
	 * @param strings
	 */
	private static void revert(char[] strings) {
		int index = strings.length / 2;
		int length = strings.length;
		for (int i = 0; i < index; i++) {
			char temp = strings[i];
			strings[i] = strings[length - 1 - i];
			strings[length - 1 - i] = temp;
		}
	}

	/**
	 * 第二种解决方案
	 * 
	 * @param s
	 */
	public void reverseString2(char[] s) {
		int low = 0;
		int high = s.length - 1;
		while (low <= high) {
			char t = s[high];
			s[high] = s[low];
			s[low] = t;
			low++;
			high--;
		}
	}

	/**
	 * 第三种解决方案
	 * 
	 * @param s
	 */
	public void reverseString3(char[] s) {
		int head = 0, tail = s.length - 1;
		while (head < tail) {
			s[head] ^= s[tail];
			s[tail] ^= s[head];
			s[head++] ^= s[tail--];
		}
	}

}
