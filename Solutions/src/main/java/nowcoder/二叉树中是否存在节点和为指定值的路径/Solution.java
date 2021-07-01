/**
 * @author Everett
 * @date 6/29/2021 2:30 PM
 */
package nowcoder.二叉树中是否存在节点和为指定值的路径;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t2.left = t3;
        t3.right = t4;
        t4.right = t5;
        System.out.println(new Solution().hasPathSum(t1, 12));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int sum, int target) {
        /**
         *  要严格按照定义写：叶子节点就是左右子节点都为空的节点v
         */
        if (root.left == null && root.right == null) {
            if (sum + (Integer) root.val == target) return true;
            return false;
        }
        boolean left = false, right = false;
        if (root.left != null)
            left = dfs(root.left, sum + (Integer) root.val, target);
        if (left) {
            return left;
        }
        if (root.right != null)
            right = dfs(root.right, sum + (Integer) root.val, target);
        return left || right;
    }
}
