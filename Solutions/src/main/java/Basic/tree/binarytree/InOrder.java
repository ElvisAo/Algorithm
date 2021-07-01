package Basic.tree.binarytree;

import java.util.Stack;

public class InOrder {
    public static void main(String[] args) {
        Node n1 = BinaryTreeUtil.getBinaryTree();
        inOrderRec(n1);
        System.out.println("======================");
        inOrderNoRec(n1);
    }

    public static void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.value);
            inOrderRec(root.right);
        }
    }

    private static void inOrderNoRec(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();
        Node t = root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                System.out.println(t.value);
                t = t.right;    // 任何二叉树都能被左分支分解
            }
        }
    }
}
