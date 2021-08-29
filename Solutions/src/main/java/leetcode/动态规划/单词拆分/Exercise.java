package leetcode.动态规划.单词拆分;

import java.util.List;

public class Exercise {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int start = i - word.length();
                if (start >= 0 && s.substring(start, i).equals(word))
                    dp[i] = dp[start] || dp[i];
            }
        }
        return dp[n];
    }
}
