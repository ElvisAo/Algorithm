package Labuladong及巧妙算法.树和图.树.三种非递归遍历;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreInPost {

    /**
     * 中序
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            list.add(t.val);
            t = t.right;
        }
        return list;
    }
}
