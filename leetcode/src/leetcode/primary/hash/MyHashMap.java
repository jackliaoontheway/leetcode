package leetcode.primary.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计哈希映射
 * https://leetcode-cn.com/submissions/detail/30930696/
 */
public class MyHashMap {

    List<Integer> keyBucket;

    List<Integer> valueBucket;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        keyBucket = new ArrayList<>();
        valueBucket = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        for (int i = 0; i < keyBucket.size(); i++) {
            if (keyBucket.get(i).equals(key)) {
                valueBucket.set(i, value);
                return;
            }
        }
        keyBucket.add(key);
        valueBucket.add(value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        for (int i = 0; i < keyBucket.size(); i++) {
            if (keyBucket.get(i).equals(key)) {
                return valueBucket.get(i);
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = -1;
        for (int i = 0; i < keyBucket.size(); i++) {
            if (keyBucket.get(i).equals(key)) {
                index = i;
            }
        }
        if (index != -1) {
            keyBucket.remove(index);
            valueBucket.remove(index);
        }
    }

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        MyHashMap hashMap = new MyHashMap();
        hashMap.remove(14);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // 返回 1
        hashMap.get(3);            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        hashMap.get(2);            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        hashMap.get(2);            // 返回 -1 (未找到)
    }
}
