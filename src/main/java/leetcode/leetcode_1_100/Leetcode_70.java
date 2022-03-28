package leetcode.leetcode_1_100;

/**
 * 70、爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Leetcode_70 {

    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int f1 = 1, f2 = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }

}
