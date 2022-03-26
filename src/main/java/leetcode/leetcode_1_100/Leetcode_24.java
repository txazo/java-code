package leetcode.leetcode_1_100;

/**
 * 24、两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Leetcode_24 {

    public ListNode swapPairs(ListNode head) {
        // 虚拟头节点
        ListNode pre = new ListNode();
        pre.next = head;
        // 递归法
        swap(pre, head);
        return pre.next;
    }

    private void swap(ListNode pre, ListNode cur) {
        if (cur == null || cur.next == null) {
            return;
        }
        ListNode next = cur.next.next;

        // 两两交换
        pre.next = cur.next;
        pre.next.next = cur;
        cur.next = next;

        // 继续后续交换
        swap(cur, cur.next);
    }

}
