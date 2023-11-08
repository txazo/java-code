package leetcode.leetcode_901_1000;

/**
 * 977、有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Leetcode_977 {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1, index = res.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

}
