package leetcode.树和图.树.二叉树的序列化与反序列化;

import common.TreeNode;

import java.util.LinkedList;

public class Solution {
    /**
     * 层序遍历：
     * 1. 序列化时将空节点序列化为“n"
     * 2. 反序列化时只对上一层的非空节点才移动当前字节串中的指针
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offerLast(root);
            StringBuilder sb = new StringBuilder();
            TreeNode c;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    c = q.poll();
                    if (c == null) {
                        sb.append('n');
                    } else {
                        sb.append(c.val);
                        q.offer(c.left);
                        q.offer(c.right);
                    }
                    sb.append(' ');
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] s = data.split(" ");
            TreeNode root = null, c;
            int size;
            LinkedList<TreeNode> preLevel = new LinkedList<>();
            if (s[0].equals("n")) return root;
            else root = new TreeNode(Integer.parseInt(s[0]));
            preLevel.offer(root);
            int sIndex = 1;
            while (!preLevel.isEmpty()) {
                size = preLevel.size();
                for (int i = 0; i < size; i++) {
                    c = preLevel.poll();
                    if (c != null) {
                        if (s[sIndex].equals("n")) c.left = null;
                        else c.left = new TreeNode(Integer.parseInt(s[sIndex]));
                        sIndex++;
                        if (s[sIndex].equals("n")) c.right = null;
                        else c.right = new TreeNode(Integer.parseInt(s[sIndex]));
                        sIndex++;
                        preLevel.offer(c.left);
                        preLevel.offer(c.right);
                    }
                }
            }
            return root;
        }
    }
}
