package leetcode.primary.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计哈希集合
 */
public class MyHashSet {

    List<Integer> bucket0;
    List<Integer> bucket1;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        // 初始化桶
        bucket0 = new ArrayList<>();
        bucket1 = new ArrayList<>();
    }

    // hash 函数
    private int hash(int key) {
        return key % 2;
    }

    // 通过hash 函数来判断使用哪个桶，这里的hash函数会有更复杂的算法
    private List<Integer> getBucket(int key) {
        if (hash(key) == 0) {
            return bucket0;
        } else {
            return bucket1;
        }
    }

    public void add(int key) {
        List<Integer> bucket = getBucket(key);
        if (bucket.contains(key)) {
            remove(key);
        }
        bucket.add(key);
    }

    public void remove(int key) {
        List<Integer> bucket = getBucket(key);
        if (bucket.contains(key)) {
            bucket.remove(Integer.valueOf(key));
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return getBucket(key).contains(key);
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // 返回 true
        System.out.println(hashSet.contains(3));    // 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // 返回  false (已经被删除)
    }

}
