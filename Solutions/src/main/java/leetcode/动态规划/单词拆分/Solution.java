package leetcode.动态规划.单词拆分;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int ln = s.length();
        boolean[] dp = new boolean[ln + 1];
        dp[0] = true;
        for (int i = 1; i <= ln; i++) {
            for (String word : wordDict) {
                int start = i - word.length();
                if (start >= 0 && word.equals(s.substring(start, i))) {
                    dp[i] = dp[i] || dp[start];
                }
            }
        }
        return dp[ln];
    }
}
