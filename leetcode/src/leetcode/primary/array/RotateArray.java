package leetcode.primary.array;

/**
 * 旋转数组 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 */

public class RotateArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4 };
		printArray(array);
		rotate(array, 4);
		System.out.println();
		printArray(array);
	}

	public static void rotate(int[] array, int k) {
		if (array == null || array.length < 2) {
			return;
		}

		if (k >= array.length) {
			k = (k % array.length);
		}
		if (k == 0) {
			return;
		}

		int[] newarray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i + k >= array.length) {
				newarray[(array.length - (i + k)) * -1] = array[i];
			} else {
				newarray[i + k] = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = newarray[i];
		}
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	public static void rotate1(int[] array, int k) {

		for (int i = 0; i < k; i++) {
			int temp = array[array.length - 1];
			for (int j = array.length - 1; j > 0; j--) {
				array[j] = array[j - 1];
			}
			array[0] = temp;
		}

	}

}
