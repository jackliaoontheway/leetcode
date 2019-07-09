package leetcode.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II 给定两个数组，编写一个函数来计算它们的交集
 */
public class DuplicatedTwoArray {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 2, 1 };
		int[] array2 = { 2, 2 };
		System.out.println(validateDuplicatedArrayItem3(array1, array2)[0]);
		System.out.println(validateDuplicatedArrayItem3(array1, array2)[1]);
	}

	// 第三种解决方案 先排序 不用list使用一个新的数组最大长度是array1 和 array2的最大长度
	// 然后用一个循环
	// 再新增一个数组保存结果 使用index 保存下标
	// 思考 凡是使用list 的地方是不是都可以用数组代替???
	private static int[] validateDuplicatedArrayItem3(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		int i = 0;
		int j = 0;

		int maxLength = (array1.length > array2.length ? array1.length : array2.length);

		int[] array = new int[maxLength];
		int index = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] == array2[j]) {
				array[index++] = array1[i];
				i++;
				j++;
			} else {
				if (array1[i] > array2[j]) {
					j++;
				} else {
					i++;
				}
			}
		}

		int[] result = new int[index];
		for (int x = 0; x < index; x++) {
			result[x] = array[x];
		}

		return result;
	}

	// 第二种解决方案 先排序 使用list
	// 然后用一个循环
	private static int[] validateDuplicatedArrayItem2(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		int i = 0;
		int j = 0;

		List<Integer> list = new ArrayList<>();
		while (i < array1.length && j < array2.length) {
			if (array1[i] == array2[j]) {
				list.add(array1[i]);
				i++;
				j++;
			} else {
				if (array1[i] > array2[j]) {
					j++;
				} else {
					i++;
				}
			}
		}

		int[] array = new int[list.size()];
		for (int x = 0; x < list.size(); x++) {
			array[x] = list.get(x);
		}
		return array;
	}

	private static int[] validateDuplicatedArrayItem(int[] array1, int[] array2) {
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
			map.put(array1[i], ++count);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array2.length; i++) {
			if (map.containsKey(array2[i]) && map.get(array2[i]) > 0) {
				list.add(array2[i]);
				map.put(array2[i], map.get(array2[i]) - 1);
			}
		}

		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array;
	}
}
