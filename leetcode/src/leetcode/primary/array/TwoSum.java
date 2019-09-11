package leetcode.primary.array;

public class TwoSum {

    public static void main(String[] args) {
        int numbers[] = {-1,0};
        int target = -1;
        int result[] = twoSum(numbers, target);
        System.out.print(result[0]);
        System.out.print(result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        label : for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == target - numbers[i]) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break label;
                }
            }
        }
        return result;
    }
}
