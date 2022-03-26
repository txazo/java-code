package leetcode.leetcode_1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Leetcode_76 {

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

            System.out.println(String.format("window: [%d, %d]", left, right));

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

    public static void main(String[] args) {
        System.out.println(new Leetcode_76().minWindow("ADBECFEBANC", "ABC"));
    }

}
