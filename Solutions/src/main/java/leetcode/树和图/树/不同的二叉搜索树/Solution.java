package leetcode.树和图.树.不同的二叉搜索树;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }

    HashMap<Integer, Integer> memo = new HashMap<>();

    {
        memo.put(0, 1);
        memo.put(1, 1);
        memo.put(2, 2);
    }

    public int numTrees(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int r = 0;
        for (int i = 1; i <= n; i++) {
            r += numTrees(i - 1) * numTrees(n - i);
        }
        memo.put(n, r);
        return r;
    }
}
