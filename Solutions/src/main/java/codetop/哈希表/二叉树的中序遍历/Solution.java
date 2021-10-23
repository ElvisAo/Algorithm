package codetop.哈希表.二叉树的中序遍历;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 94
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }
}
