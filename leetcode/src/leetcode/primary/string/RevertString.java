package leetcode.primary.string;

public class RevertString {

	public static void main(String[] args) {

		char[] strings = { 'h', 'e', 'l', 'l', 'o' };
		revert2(strings);
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + ",");
		}
	}

	/**
	 * 第一种解决方案
	 * 
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
	 * 第二种解决方案 使用双指针法
	 */
	private static void revert2(char[] strings) {
		for (int i = 0, x = (strings.length - 1); i < x; i++, x--) {
			char temp = strings[i];
			strings[i] = strings[x];
			strings[x] = temp;
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
