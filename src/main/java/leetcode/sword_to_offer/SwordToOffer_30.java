package leetcode.sword_to_offer;

import java.util.Stack;

/**
 * 剑指 Offer 30、包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class SwordToOffer_30 {

    static class MinStack {

        private final Stack<Integer> dataStack = new Stack<>();
        private final Stack<Integer> minStack = new Stack<>();

        public MinStack() {
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));
            }
        }

        public void pop() {
            if (dataStack.isEmpty()) {
                return;
            }
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            if (dataStack.isEmpty()) {
                return -1;
            }
            return dataStack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }

    }

}
