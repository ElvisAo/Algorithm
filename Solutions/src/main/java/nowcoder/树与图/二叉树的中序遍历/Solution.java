package nowcoder.树与图.二叉树的中序遍历;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    List<Integer> list = new LinkedList<>();

    public int[] solution_1(TreeNode root) {
        helper(root);
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    private void helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }

    public int[] solution_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                list.add(t.val);
                t = t.right;
            }
        }
        int[] r = new int[list.size()];
        int ri = 0;
        while (!list.isEmpty()) {
            r[ri++] = list.removeFirst();
        }
        return r;
    }
}
