package leetcode.动态规划.单词拆分;

import java.util.List;

/**
 * 题目描述：
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
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
