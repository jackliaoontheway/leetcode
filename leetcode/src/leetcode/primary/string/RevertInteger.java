package leetcode.primary.string;

/**
 * 整数反转
 *
 */
public class RevertInteger {

	public static void main(String[] args) {
		Integer i = -120;
		i = revert(i);
		System.out.println(i);
	}

	private static void revert(char[] strings) {
		int index = strings.length / 2;
		int length = strings.length;
		for (int i = 0; i < index; i++) {
			char temp = strings[i];
			strings[i] = strings[length - 1 - i];
			strings[length - 1 - i] = temp;
		}
	}

	private static Integer revert(Integer i) {
		String s = i + "";

		int index = s.indexOf("-");
		if(index != -1) {
			s = s.substring(1);
		}
		
		char[] ss = s.toCharArray();
		revert(ss);
		s = new String(ss);

		Long l = Long.parseLong(s);

		if (l > Integer.MAX_VALUE) {
			return 0;
		}
		
		if(index != -1) {
			return (-1 * l.intValue());
		} 

		return l.intValue();
	}

}
