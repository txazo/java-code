package leetcode.leetcode_101_200;

/**
 * 189、轮转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Leetcode_189 {

    /**
     * 方案一: 新建一个数组
     * 方案二: 原地O(1)
     * 方案三: 翻转数据
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = temp;
        }
    }

}
