package leetcode.primary.array;

import java.util.Arrays;

/**
 * 长度最小的子数组
 *
 * https://leetcode-cn.com/submissions/detail/30279887/
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int s = 15;
        int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};

        System.out.print(minSubArrayLen3(15, nums));
    }

    /**
     * 第二种解法
     */
    public static int minSubArrayLen3(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) {
                return 1;
            }
            sum += nums[i];
            if (sum >= s) {
                int temp = sum;
                for (int j = 0; j < i; j++) {
                    temp -= nums[j];
                    if (temp <= s) {
                        minLen = Math.min(minLen, i - j + 1);
                        break;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
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
