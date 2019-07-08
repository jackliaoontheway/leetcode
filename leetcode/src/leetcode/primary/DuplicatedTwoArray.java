package leetcode.primary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II 给定两个数组，编写一个函数来计算它们的交集
 */
public class DuplicatedTwoArray {

	public static void main(String[] args) {
		int[] array1 = { 1,2,2,1 };
		int[] array2 = { 2,2 };
		System.out.println(validateDuplicatedArrayItem(array1,array2)[0]);
		System.out.println(validateDuplicatedArrayItem(array1,array2)[1]);
	}

	private static int [] validateDuplicatedArrayItem(int[] array1,int[] array2) {
		if (array1 == null || array1.length == 0) {
			return new int[0];
		}
		if (array2 == null || array2.length == 0) {
			return new int[0];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array1.length; i++) {
			Integer count = map.get(array1[i]);
			count = (count == null ? 0 : count);
			map.put(array1[i],++count);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < array2.length; i++) {
			if(map.containsKey(array2[i]) && map.get(array2[i]) > 0) {
				list.add(array2[i]);
				map.put(array2[i],map.get(array2[i]) - 1);
			}
		}
		
		int [] array = new int [list.size()];
		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
}
