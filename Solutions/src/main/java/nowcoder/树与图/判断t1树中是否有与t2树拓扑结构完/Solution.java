package nowcoder.树与图.判断t1树中是否有与t2树拓扑结构完;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isContains(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if (root1.val == root2.val && isContains(root1.left, root2.left) && isContains(root1.right, root2.right)) {
            return true;
        } else {
            return isContains(root1, root2.left) || isContains(root1, root2.right);
        }
    }
}
