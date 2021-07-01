package leetcode.编辑距离;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(new Solution().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
//        return solution_1(word1, word2, word1.length() - 1, word2.length() - 1);
        return solution_2(word1, word2);
    }

    private HashMap<String, Integer> memo = new HashMap<>();    // 纯暴力超时，用备忘录优化

    private int solution_1(String s1, String s2, int i, int j) {
        if (i == -1 && j == -1) return 0;
        else if (i != -1 && j == -1) return i + 1;
        else if (i == -1 && j != -1) return j + 1;
        String key = i + "" + j;
        if (memo.containsKey(key)) return memo.get(key);
        if (s1.charAt(i) == s2.charAt(j)) return solution_1(s1, s2, i - 1, j - 1);
        int ins = solution_1(s1, s2, i, j - 1);
        int del = solution_1(s1, s2, i - 1, j);
        int rep = solution_1(s1, s2, i - 1, j - 1);
        int r = Math.min(
                Math.min(ins, del), rep
        ) + 1;
        memo.put(key, r);
        return r;
    }

    /**
     * {@动态规划：状态+选择}
     * {这里的状态就是s1和s2比较的位置}
     * {@通常，有几个状态，就有几个循环}
     * {@递归是自顶向下，动态规划是自底向上}
     * {@因为递归的本质是在求出“底层”的结果后，利用底层的结果进行计算}
     * {@而动态规划，因为通常是使用dp数组，直接依赖底层结果，所以如果底层结果不先计算出来，上层结果是无法计算的}
     */
    private int solution_2(String s1, String s2) {
        int ln1 = s1.length(), ln2 = s2.length();
        int[][] dp = new int[ln1 + 1][ln2 + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
