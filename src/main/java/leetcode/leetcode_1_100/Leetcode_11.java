package leetcode.leetcode_1_100;

/**
 * 11、盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Leetcode_11 {

    /**
     * 双指针
     */
    public int maxArea(int[] height) {
        // 双指针
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            // 每次移动较小的边
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }

}
