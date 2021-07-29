package nowcoder.树与图.实现二叉数先序_中序和后序打印所有节点;

import common.TreeNode;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }

    public int[][] threeOrders(TreeNode root) {
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> post = new LinkedList<>();
        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);
        int[][] r = new int[3][pre.size()];
        int i = 0;
        while (!pre.isEmpty()) r[0][i++] = pre.poll();
        i = 0;
        while (!in.isEmpty()) r[1][i++] = in.poll();
        i = 0;
        while (!post.isEmpty()) r[2][i++] = post.poll();
        return r;
    }

    public void preOrder(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            list.offer(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public void inOrder(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.offer(root.val);
            inOrder(root.right, list);
        }
    }

    public void postOrder(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.offer(root.val);
        }
    }
}
