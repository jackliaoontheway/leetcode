package leetcode.primary.array;

/**
 * 移除元素
 */
public class RemoveElement {


    public static void main(String[] args) {
        int nums [] = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.print(removeElement(nums,val));
        for(int i : nums) {
            System.out.print(i);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int x0 = 0;
        int x1 = 0;
        while(x1 < nums.length) {
            if(nums[x1] != val) {
                int temp = nums[x0];
                nums[x0] = nums[x1];
                nums[x1] = temp;
                x0 ++;
            }
            x1 ++;
        }
        return x0;
    }

}
