package leetcode.primary.hash;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/submissions/detail/32888257/
 */
public class RandomizedSet {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        Integer[] array = hashSet.toArray(new Integer[hashSet.size()]);
        System.out.println(array[new Random().nextInt(array.length)]);
    }

    private Set<Integer> hashSet;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        hashSet = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return hashSet.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return hashSet.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (hashSet.size() == 0) {
            return 0;
        }
        Integer[] array = hashSet.toArray(new Integer[hashSet.size()]);
        return array[new Random().nextInt(array.length)];
    }


}
