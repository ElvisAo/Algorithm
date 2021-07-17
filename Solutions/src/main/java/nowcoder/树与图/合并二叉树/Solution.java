package nowcoder.树与图.合并二叉树;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode<Integer> mergeTrees(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
