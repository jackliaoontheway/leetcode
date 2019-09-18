package leetcode.primary.array;

import java.util.Arrays;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.print(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            l++;
            if (sum >= s) {
                return l;
            }
        }
        return 0;
    }

}
