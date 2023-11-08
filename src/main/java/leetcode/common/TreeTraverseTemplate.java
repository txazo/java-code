package leetcode.common;

/**
 * 二叉树遍历
 */
public class TreeTraverseTemplate {

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }

}
