package leetcode.sword_to_offer;

/**
 * 剑指 Offer 24、反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class SwordToOffer_24 {

    /**
     * 1、两两反转
     * 2、递归/动态规划
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next;
        pre.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
