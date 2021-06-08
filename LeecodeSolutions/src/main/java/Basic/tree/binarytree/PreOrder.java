package Basic.tree.binarytree;

import java.util.Stack;

public class PreOrder {
    public static void main(String[] args) {
        Node n1 = BinaryTreeUtil.getBinaryTree();
        preOrderRec(n1);
        System.out.println("++++++++++++++++++++++");
        preOrderNoRec(n1);
    }

    public static void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public static void preOrderNoRec(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node t;
        while (!stack.isEmpty()) {
            t = stack.pop();
            System.out.println(t.value);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
    }
}
