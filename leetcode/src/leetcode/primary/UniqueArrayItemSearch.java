package leetcode.primary;

/**
 * 
 * 只出现一次的数字
 */
public class UniqueArrayItemSearch {

	public static void main(String[] args) {
		int[] array = { 2, 2 ,1 };
		System.out.println(getUniqueArrayItem(array));
	}

	public static int getUniqueArrayItem(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean isExisted = false;
			if(i == array.length - 1) {
				return array[i];
			}
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					isExisted = true;
					break;
				}
			}
			
			for (int k = 0; k < i; k++) {
				if (array[i] == array[k]) {
					isExisted = true;
					break;
				}
			}
			if (!isExisted) {
				return array[i];
			}
		}
		return array[array.length - 1];
	}

}
