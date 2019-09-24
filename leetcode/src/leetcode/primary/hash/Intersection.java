package leetcode.primary.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/submissions/detail/31052176/
 */
public class Intersection {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        for (Integer item : result) {
            System.out.print(item);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (Integer item : nums1) {
            set.add(item);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (Integer item : nums2) {
            if (set.contains(item)) {
                resultSet.add(item);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer item : resultSet) {
            result[index++] = item;
        }
        return result;
    }


}
