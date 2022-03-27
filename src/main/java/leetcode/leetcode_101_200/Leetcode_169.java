package leetcode.leetcode_101_200;

/**
 * 169、多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Leetcode_169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else if (--count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

}
