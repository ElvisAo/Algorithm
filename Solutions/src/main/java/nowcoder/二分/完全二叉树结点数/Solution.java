package nowcoder.二分.完全二叉树结点数;

import common.TreeNode;

/**
 * {@注意：不是满二叉树}
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int nodeNum(TreeNode head) {
        if (head == null) return 0;
        int l = 0, r = 0;
        TreeNode t = head;
        while (t.left != null) {
            l++;
            t = t.left;
        }
        t = head;
        while (t.right != null) {
            r++;
            t = t.right;
        }
        if (l == r) {
            return (int) Math.pow(2, l + 1) - 1;
        } else {
            return 1 + nodeNum(head.left) + nodeNum(head.right);
        }
    }

}
