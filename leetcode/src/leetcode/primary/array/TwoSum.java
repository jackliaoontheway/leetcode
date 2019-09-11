package leetcode.primary.array;

/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/submissions/detail/29419230/
 */
public class TwoSum {

    public static void main(String[] args) {
        int numbers[] = {-1, 0};
        int target = -1;
        int result[] = twoSum2(numbers, target);
        System.out.print(result[0]);
        System.out.print(result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        label:
        for (int i = 0; i < numbers.length; i++) {
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


    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                result[0] = head + 1;
                result[1] = tail + 1;
                break;
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return result;
    }
}
