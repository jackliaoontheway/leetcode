package leetcode.primary.string;

/**
 * 整数反转
 *
 */
public class RevertInteger {

	public static void main(String[] args) {
		Integer i = -120;
		i = revert2(i);
		System.out.println(i);
	}
	/**
	 * 第二种解决方案 使用取余和除10 乘10
	 * @param i
	 * @return
	 */
	private static Integer revert2(Integer i) {
		if(i == null) {
			return null;
		}
		int result = 0;
		while(i != 0) {
			int m = i % 10;
			result = ((result *= 10) + m);
			i /= 10;
			if(result > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return result;
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
	
	
	
	
	
	//https://leetcode-cn.com/submissions/detail/23303353/
	public int reverse(int x) {
        long result = 0;
        int max = 0x80000000;
        int min = 0x7fffffff;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;
            result = result * 10 + mod;
            if (result > Integer.MAX_VALUE || result < (long) Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

}
