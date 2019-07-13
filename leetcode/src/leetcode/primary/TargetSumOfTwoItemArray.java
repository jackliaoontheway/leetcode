package leetcode.primary;

/**
 * 两数之和
 */
public class TargetSumOfTwoItemArray {

	public static void main(String[] args) {
		int[] array = { 2, 1, 40, 0, 3, 12 };
		int[] x = sum(array, 3);
		System.out.println(x[0] +"--"+ x[1]);
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
