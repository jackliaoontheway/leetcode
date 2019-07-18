package leetcode.primary.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */
public class MoveZeroToEndOfArray {

	public static void main(String[] args) {
//		int[] array = { 0,0,1};
		int[] array = { 2,1,40,0,3,12};
		moveZeroes(array);
		printArray(array);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	/**
	 * 这个是其他人的解决方案
	 * 这个方案会有个问题 2,1,40,0,3,12 破坏了原有数组的顺序
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                if(i == k){
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
    }
	
	/**
	 * 其他人的解决方案 没有嵌套 2个for
	 * done
	 * @param array
	 */
	public static void rotate2(int[] array) {
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				array[j] = array[i];
				j ++;
			}
		}
		for(int k = j; k < array.length; k ++) {
			array[k] = 0;
		}
	}
	
	/**
	 * 我的解决方案2
	 * 出现了嵌套 一个for
	 * @param array
	 */
	public static void rotate1(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] == 0) {
				int temp = array[i];
				for (int j = i; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 1] = temp;
			}
		}
	}
	
	/**
	 * 我的解决方案1
	 * 出现了嵌套 嵌套了两个for
	 * @param array
	 */
	public static void rotate0(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				boolean hasOther = false;
				for(int j = i; j < array.length; j++) {
					if(array[j] != 0) {
						hasOther = true;
						break;
					}
				}
				if(hasOther) {
					int temp = array[i];
					for (int j = i; j < array.length - 1; j++) {
						array[j] = array[j + 1];
					}
					array[array.length - 1] = temp;
					i --;
				}
			}
		}
	}
}
