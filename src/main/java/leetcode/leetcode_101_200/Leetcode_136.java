package leetcode.leetcode_101_200;

/**
 * 136、只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 */
public class Leetcode_136 {

    /**
     * 按位异或
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
