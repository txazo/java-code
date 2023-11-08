package leetcode.leetcode_1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76、最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Leetcode_76 {

    /**
     * 滑动窗口、哈希表
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        // 当前窗口
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口左右指针
        int left = 0, right = 0;
        // window和need匹配的字符数
        int valid = 0;
        int minStart = 0, minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            // 收缩滑动窗口
            while (valid == need.size()) {
                if (right - left < minLength) {
                    minStart = left;
                    minLength = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

}
