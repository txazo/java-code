package leetcode.leetcode_1_100;

/**
 * 75、颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Leetcode_75 {

    /**
     * 单指针
     */
    public void sortColors(int[] nums) {
        int index = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, index);
                index++;
            }
        }
        for (int i = index; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, index);
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
