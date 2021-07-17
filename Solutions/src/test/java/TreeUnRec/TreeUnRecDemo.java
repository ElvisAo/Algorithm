package TreeUnRec;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUnRecDemo {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();
        new TreeUnRecDemo().levelOrder(root);
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            System.out.println(t.val);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                System.out.println(t.val);
                t = t.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        TreeNode t;
        stk1.push(root);
        while (!stk1.isEmpty()) {
            t = stk1.pop();
            stk2.push(t);
            if (t.left != null) stk1.push(t.left);
            if (t.right != null) stk1.push(t.right);
        }
        while (!stk2.isEmpty()) {
            System.out.println(stk2.pop().val);
        }
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                System.out.println(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
    }
}
