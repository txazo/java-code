package leetcode.common;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS模板
 * <p>
 * 1、二叉树BFS: 层序遍历
 * 2、矩阵BFS: 每个节点向上下左右四个方向扩散
 * 3、多源BFS: 多个起始节点
 */
public class BFSTemplate {

    /**
     * 二叉树BFS
     */
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

}
