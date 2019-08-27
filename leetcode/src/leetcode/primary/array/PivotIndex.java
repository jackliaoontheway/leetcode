package leetcode.primary.array;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex {

    public static void main(String[] args) {
        int [] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex(nums));
    }

    /**
     * 没有考虑到负数的情况
     */
    public static int pivotIndex(int [] nums) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        int head = 0;
        int tail = nums.length - 1;
        int left = nums[head ++];
        int right = nums[tail];
        while(head != tail) {
            if(left < right) {
                left += nums[head ++];
            } else if(left > right) {
                right += nums[--tail];
            }
            if(left == right) {
                return head;
            }
        }
        return  -1;
    }

    public static int pivotIndex2(int[] nums) {
        int sumTotal = 0;
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sumTotal += nums[i];
        }
        for (int p = 0; p < nums.length; p++) {

            if (sumLeft * 2 == sumTotal - nums[p]) {
                return p;
            }
            sumLeft += nums[p];
        }
        return -1;
    }
}
