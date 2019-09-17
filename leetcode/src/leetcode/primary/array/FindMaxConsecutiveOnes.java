package leetcode.primary.array;

/**
 * 最大连续1的个数
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int nums[] = {1, 1,0};
        System.out.print(findMaxConsecutiveOnes(nums));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxConsecutive = 0;
        int tempConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempConsecutive++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, tempConsecutive);
                tempConsecutive = 0;
            }
        }
        return Math.max(maxConsecutive, tempConsecutive);
    }

}
