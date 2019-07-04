package leetcode.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class RemoveDuplicatedArrayItem {
	
	public static void main(String[] args) {
		
	}

	public static int solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int num : nums) {
			if (!map.containsValue(num)) {
				map.put(index++, num);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			nums[entry.getKey()] = entry.getValue();
		}
		return map.size();
	}

	// 第二个解决方案 使用双指针法
	// 直接使用for 循环从 j= 1开始,
	public static int solution2(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			// 注意 这里是有序数组 // 所以nums[j] 不需要和nums[i]前面 比较
			// 这里只需要判断是不是和nums[i] 比较就可以了
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

}
