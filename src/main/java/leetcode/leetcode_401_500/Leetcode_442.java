package leetcode.leetcode_401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * 442、数组中重复的数据
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class Leetcode_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        int n = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] % n) - 1] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * n) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
