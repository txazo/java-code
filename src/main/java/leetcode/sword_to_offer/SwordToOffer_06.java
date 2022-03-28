package leetcode.sword_to_offer;

import java.util.Stack;

/**
 * 剑指 Offer 06、从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class SwordToOffer_06 {

    /**
     * 栈
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int index = 0;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    /**
     * 尾递归
     */
    public int[] reversePrint2(ListNode head) {
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        int[] res = new int[n];
        recursive(head, res);
        return res;
    }

    private int recursive(ListNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int index = recursive(node.next, res);
        res[index] = node.val;
        return index + 1;
    }

}
