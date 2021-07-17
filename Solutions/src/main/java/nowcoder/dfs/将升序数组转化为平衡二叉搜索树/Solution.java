package nowcoder.dfs.将升序数组转化为平衡二叉搜索树;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] t = {1, 3, 4, 5};
        TreeNode root = new Solution().sortedArrayToBST(t);
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return dfs(num, 0, num.length - 1);
    }

    private TreeNode dfs(int[] num, int s, int e) {
        if (s > e) return null;
        int mid = -1;
        if ((e - s) % 2 == 0) mid = (e + s) / 2;
        else mid = (e + s + 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = dfs(num, s, mid - 1);
        root.right = dfs(num, mid + 1, e);
        return root;
    }

}
