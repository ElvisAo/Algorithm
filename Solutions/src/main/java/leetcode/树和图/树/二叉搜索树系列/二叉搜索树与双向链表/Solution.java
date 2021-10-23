package leetcode.树和图.树.二叉搜索树系列.二叉搜索树与双向链表;

class Node {
    int val;
    Node left, right;
}

/**
 * 二叉树展为循环双向链表
 */
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private Node pre = null;
    private Node head = null;

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            if (pre != null) {
                pre.right = root;
                root.left = pre;
            }
            if (head == null) head = root;
            pre = root;
            inOrder(root.right);
        }
    }
}
