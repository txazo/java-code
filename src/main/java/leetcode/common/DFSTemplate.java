package leetcode.common;

/**
 * DFS模板
 */
public class DFSTemplate {

    /**
     * 二叉树DFS
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历
        dfs(root.left);
        dfs(root.right);
    }

}
