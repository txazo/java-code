package leetcode.leetcode_701_800;

import java.util.HashMap;
import java.util.Map;

/**
 * 706、设计哈希映射
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * https://leetcode-cn.com/problems/design-hashmap/
 */
public class Leetcode_706 {

    static class MyHashMap {

        private final Map<Integer, Integer> map = new HashMap<>();

        public MyHashMap() {
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void remove(int key) {
            map.remove(key);
        }

    }

}
