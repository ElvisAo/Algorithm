package leetcode.树和图.树.找树左下角的值;

import common.TreeNode;

import java.util.LinkedList;

/**
 * leetcode 513
 */
public class Solution {
    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode t = root, bottomLeft = t;
        q.offer(t);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                t = q.poll();
                if (i == 0) {
                    bottomLeft = t;
                }
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return bottomLeft.val;
    }
}
