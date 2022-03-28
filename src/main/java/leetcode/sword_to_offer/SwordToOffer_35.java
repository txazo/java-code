package leetcode.sword_to_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35、复杂链表的复制
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class SwordToOffer_35 {

    /**
     * 哈希表
     */
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }

    private Node copyRandomList(Node head, Map<Node, Node> cacheMap) {
        if (head == null) {
            return null;
        }
        if (!cacheMap.containsKey(head)) {
            Node newHead = new Node(head.val);
            cacheMap.put(head, newHead);
            newHead.next = copyRandomList(head.next, cacheMap);
            newHead.random = copyRandomList(head.random, cacheMap);
        }
        return cacheMap.get(head);
    }

    static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

}
