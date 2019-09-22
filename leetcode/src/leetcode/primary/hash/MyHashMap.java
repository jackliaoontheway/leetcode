package leetcode.primary.hash;

public class MyHashMap {

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return key;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
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
