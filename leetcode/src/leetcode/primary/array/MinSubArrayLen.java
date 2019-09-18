package leetcode.primary.array;

import java.util.Arrays;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 3, 3, 2};
        System.out.print(minSubArrayLen2(7, nums));
    }

    /**
     * 第二种解法
     */
    public static int minSubArrayLen3(int s, int[] nums) {
        int minLen = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) {
                return 1;
            }
            sum += nums[i];
            if (sum >= s) {
                int x = 1;
                int temp = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    x++;
                    temp += nums[j];
                    if (temp >= s) {
                        minLen = minLen == 0 ? x : Math.min(minLen, x);
                    }
                }
            }
        }
        return minLen;
    }

    /**
     * 第一种解法
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int minLen = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) {
                return 1;
            }
            sum += nums[i];
            if (sum >= s) {
                int x = 1;
                int temp = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    x++;
                    temp += nums[j];
                    if (temp >= s) {
                        minLen = minLen == 0 ? x : Math.min(minLen, x);
                    }
                }
            }
        }
        return minLen;
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
