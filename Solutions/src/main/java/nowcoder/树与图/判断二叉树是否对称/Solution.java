/**
 * @author Everett
 * @date 6/28/2021 6:02 PM
 */
package nowcoder.树与图.判断二叉树是否对称;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        n1.left = n2;
        System.out.println(new Solution().solution_1(n1));
    }

    public boolean solution_1(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    list.add((Integer) t.val);
                    q.offer(t.left);
                    q.offer(t.right);
                } else list.add(null);
            }
            if (!isPaldrome(list)) return false;
        }
        return true;
    }

    private boolean isPaldrome(ArrayList<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != null && list.get(j) != null) {
                if (list.get(i) != list.get(j)) return false;
            } else if (list.get(i) == null && list.get(j) == null) {
                continue;
            } else return false;
        }
        return true;
    }

    public boolean solution_2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymetric(root.left, root.right);
    }

    // r1、r2最开始都不为空
    private boolean isSymetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        else if (r1 != null && r2 != null && r1.val == r2.val) {
            boolean outer = isSymetric(r1.left, r2.right);
            boolean inner = isSymetric(r1.right, r2.left);
            return outer && inner;
        } else return false;
    }
}
