package leetcode.leetcode_201_300;

/**
 * 283、移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Leetcode_283 {

    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        // left: left左边均为非0
        // left和right之间均为0
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
