package leetcode.primary;

import java.util.Set;
import java.util.TreeSet;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集
 */
public class DuplicatedTwoArray {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 1,5 };
		int[] array2 = { 1, 2, 3, 4, 1 };
		System.out.println(validateDuplicatedArrayItem(array1,array2));
	}

	private static Set<Integer> validateDuplicatedArrayItem(int[] array1,int[] array2) {
		Set<Integer> set = new TreeSet<>();
		if (array1 == null || array1.length == 0) {
			return set;
		}
		if (array2 == null || array2.length == 0) {
			return set;
		}

		for (int i = 0; i < array1.length; i++) {
			set.add(array1[i]);
		}
		
		Set<Integer> newset = new TreeSet<>();
		for(int i = 0; i < array2.length; i++) {
			if(set.contains(array2[i])) {
				newset.add(array2[i]);
			}
		}

		return newset;
	}
	
	private static int [] validateDuplicatedArrayItem2(int[] array1,int[] array2) {
		if (array1 == null || array1.length == 0) {
			return null;
		}
		if (array2 == null || array2.length == 0) {
			return null;
		}

		for (int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				
			}
		}
		
		

		return null;
	}
}
