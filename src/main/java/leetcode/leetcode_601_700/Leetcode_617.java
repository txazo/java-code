package leetcode.leetcode_601_700;

/**
 * 617、合并二叉树
 * <p>
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Leetcode_617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode();
        newRoot.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        newRoot.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        newRoot.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return newRoot;
    }

}
