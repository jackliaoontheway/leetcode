package leetcode.primary;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false
 */
public class DuplicatedArrayItemValidation {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 1 };
		System.out.println(validateDuplicatedArrayItem2(array));
	}

	public static boolean validateDuplicatedArrayItem2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean validateDuplicatedArrayItem(int[] array) {
		Set<Integer> set = new TreeSet<>();
		if (array == null || array.length == 0) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		return set.size() < array.length;
	}
}
