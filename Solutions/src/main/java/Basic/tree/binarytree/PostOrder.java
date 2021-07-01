package Basic.tree.binarytree;

import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {
        Node root = BinaryTreeUtil.getBinaryTree();
        postOrderReC(root);
        System.out.println("==========================");
        postOrderNoRecViaPreOrder(root);
        System.out.println("==========================");
        postOrderNoRecSingleStack(root);
    }

    public static void postOrderReC(Node root) {
        if (root != null) {
            postOrderReC(root.left);
            postOrderReC(root.right);
            System.out.println(root.value);
        }
    }

    public static void postOrderNoRecViaPreOrder(Node root) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>(); // 收集栈
        Node t = root;
        stack1.push(t);
        while (!stack1.isEmpty()) { // 利用先序变种实现后序
            t = stack1.pop();
            if (t.left != null) stack1.push(t.left);
            if (t.right != null) stack1.push(t.right);
            stack2.push(t);
        }
        while (!stack2.isEmpty()) {
            t = stack2.pop();
            System.out.println(t.value);
        }
    }

    public static void postOrderNoRecSingleStack(Node root) {
        // 核心：用一个节点来标记上次访问的节点，以表明本次该访问的是右子节点还是当前子树的根节点
        Stack<Node> stack = new Stack<Node>();
        Node t = root, lastVisited = null;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.peek();
                if (t.right != null && t.right != lastVisited) {
                    t = t.right;
                } else {
                    t = stack.pop();
                    System.out.println(t.value);
                    lastVisited = t;
                    t = null;
                }
            }
        }
    }
}
