package leetcode.primary;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */
public class MoveZeroToEndOfArray {

	public static void main(String[] args) {
//		int[] array = { 0,0,1};
		int[] array = { 0,1,0,3,12};
		rotate2(array);
		printArray(array);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	public static void rotate2(int[] array) {
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

	// has error
	public static void rotate(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				int temp = array[i];
				for (int j = i; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 1] = temp;
			}
		}
	}
}
