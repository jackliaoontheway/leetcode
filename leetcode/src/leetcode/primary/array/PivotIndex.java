package leetcode.primary.array;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1};
        System.out.println(pivotIndex2(nums));
    }

    public static int pivotIndex2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int leftSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 这里不能用除 会有精度问题
            // 总和 - nums[i] = 剩余的和(nums[i] 的左边 + nums[i]的右边)
            // 剩余的和 / 左边 == 2 说明左边占剩余的和的一半 也就是左边等于右边
            if((sum - nums[i]) / 2 == leftSum) {
                return i;
            }
            if(((sum - nums[i])) == leftSum * 2) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * ???
     * 没有考虑到负数的情况
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int head = 0;
        int tail = nums.length - 1;
        int left = nums[head++];
        int right = nums[tail];
        int result = -1;
        while (head != tail) {
            if (left < right) {
                left += nums[head++];
            } else if (left > right) {
                right += nums[--tail];
            }
            if (left == right) {
                result = head;
                left += nums[head++];
            }
        }
        return result;
    }


}
