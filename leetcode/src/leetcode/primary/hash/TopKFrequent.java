package leetcode.primary.hash;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1,2};
        int k = 2;
        List<Integer> result = new TopKFrequent().topKFrequent(nums, k);
        for (int x : result) {
            System.out.print(x);
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 放元素出现的次数Map key = 元素 value 是次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int times = 0;
            if (map.containsKey(num)) {
                times = map.get(num);
            }
            times++;
            map.put(num, times);
        }

        List<Integer> list = new ArrayList(map.values());
        Collections.sort(list);
        int x = list.get(list.size() - k);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= x) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
