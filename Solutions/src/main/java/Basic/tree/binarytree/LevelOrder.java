package Basic.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        Node root = BinaryTreeUtil.getBinaryTree();
        levelOrder(root);
        getMaxWidth(root);
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node t = root;
        queue.offer(t);
        while (!queue.isEmpty()) {
            t = queue.poll();
            System.out.println(t.value);
            if (t.left != null) queue.offer(t.left);
            if (t.right != null) queue.offer(t.right);
        }
    }

    public static void getMaxWidth(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        Node t = root, lastNode = t;
        int maxWidth = 1;
        queue.offer(t);
        while (!queue.isEmpty()) {
            t = queue.poll();
            if (t.left != null) queue.offer(t.left);
            if (t.right != null) queue.offer(t.right);
            if (t == lastNode && queue.size() > 0) {
                if (queue.size() > maxWidth){
                    maxWidth = queue.size();
                }
                lastNode = queue.getLast();
            }
        }
        System.out.println("最大宽度：" + maxWidth);
    }
}
