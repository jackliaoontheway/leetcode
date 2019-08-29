package leetcode.primary.array;

import java.util.Arrays;

/**
 * 至少是其他数字两倍的最大数
 */
public class DominantIndex {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1};
        System.out.print(dominanIndex(nums));
    }

    public static int dominanIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if(nums.length == 1) {
            return 0;
        }

        int maxIndex = 0;
        int nearMaxIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[maxIndex] < nums[i]) {
                nearMaxIndex = maxIndex;
                maxIndex = i;
            } else {
                if(nums[nearMaxIndex] <= nums[i]) {
                    nearMaxIndex = i;
                }
            }
        }
        if (nums[nearMaxIndex] == 0 && nums[maxIndex] > 0) {
            return maxIndex;
        }
        if (nums[maxIndex] / nums[nearMaxIndex] >= 2) {
            return maxIndex;
        }
        return -1;
    }

    public static int dominantNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 2] == 0 || nums[nums.length - 1] < 2) {
            return -1;
        }
        if (nums[nums.length - 1] / nums[nums.length - 2] >= 2) {
            return nums[nums.length - 1];
        }
        return -1;
    }
}
