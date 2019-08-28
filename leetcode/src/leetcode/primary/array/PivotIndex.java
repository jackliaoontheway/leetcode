package leetcode.primary.array;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex {

    public static void main(String[] args) {
        int [] nums = {-1,-1,-1,0,-1,-1,-1};
        System.out.println(pivotIndex2(nums));
    }

    /**
     * ???
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
        int result = -1;
        while(head != tail) {
            if(left < right) {
                left += nums[head ++];
            } else if(left > right) {
                right += nums[--tail];
            }
            if(left == right) {
                result = head;
                left += nums[head ++];
            }
        }
        return  result;
    }


    public static int pivotIndex2(int[] nums) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            // 逆向思维
            // 总和 - nums[i] = 剩余的和(nums[i] 的左边 + nums[i]的右边)
            // 剩余的和 / 左边 == 2 说明左边占剩余的和的一半 也就是左边等于右边
            if((sum - nums[i]) % 2 == 0 && (sum - nums[i]) / 2 == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
