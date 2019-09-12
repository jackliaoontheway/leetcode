package leetcode.primary.array;

import java.util.Arrays;

/**
 * 数组拆分 I
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        int nums[] = {1, 4, 3, 2};
        System.out.print(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        int minTotal = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                minTotal += nums[i];
            }
        }

        return minTotal;
    }

    public static int arrayPairSum2(int[] nums) {
        int minTotal = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            minTotal += nums[i];
        }

        return minTotal;
    }

}
