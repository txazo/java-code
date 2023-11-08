package leetcode.leetcode_1101_1200;

/**
 * 1137、第 N 个泰波那契数
 * <p>
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Leetcode_1137 {

    public int tribonacci(int n) {
        int f0 = 0, f1 = 1, f2 = 1;
        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1;
        }
        for (int i = 3; i <= n; i++) {
            int temp = f0 + f1 + f2;
            f0 = f1;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }

}
