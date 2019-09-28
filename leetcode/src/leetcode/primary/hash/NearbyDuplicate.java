package leetcode.primary.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在重复元素 II
 */
public class NearbyDuplicate {

    public static void main(String[] args) {
        int nums[] = {1,0,1,1};
        System.out.print(new NearbyDuplicate().containsNearbyDuplicate(nums,1));
    }

    /**
     * 第一种解决方案
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i],list);
            }
            list.add(i);
            if (list.size() > 1) {
                if (list.get(list.size() - 1) - list.get(list.size() - 2) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
