package leetcode.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TargetSumOfTwoItemArray {

	public static void main(String[] args) {
		int[] array = { 2, 1, 40, 0, 3, 12 };
		int[] x = sum2(array, 3);
		System.out.println(x[0] +"--"+ x[1]);
	}
	
	public static int[] sum2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if(indexMap.containsKey(temp)) {
				result[0] = indexMap.get(temp);
				result[1] = i;
				return result;
			}
			indexMap.put(nums[i],i);
		}
		return result;
	}

	public static int[] sum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
}
