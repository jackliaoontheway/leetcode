package leetcode.primary.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 第一种方案 使用暴力法 第二种方案 使用Map
 * 
 * 第三种方案 使用 异或 第四种方案 使用 set
 * 
 * *** 注意是 其他数字是出现两次 如果出现3次的话 set和异或就不适合了
 */
public class UniqueArrayItemSearch {

	public static void main(String[] args) {
		int[] array = { 2, 2, 1, 1, 5, 4, 4 };
		System.out.println(getUniqueArrayItem3(array));
	}

	public static int getUniqueArrayItem3(int[] nums) {
		int res = 0;
		for (Integer num : nums) {
			res ^= num;
		}
		return res;
	}

	public static int getUniqueArrayItem4(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		return (int) set.iterator().next();
	}

	public static int getUniqueArrayItem2(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return -1;
	}

	public static int getUniqueArrayItem(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean isExisted = false;
			if (i == array.length - 1) {
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
