package leetcode.动态规划.单词拆分Ⅱ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 动态规划求解是否有解
 * 回溯求具体解
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
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
        HashSet<String> r = new HashSet<>();
        if (!dp[n]) return new LinkedList<>();
        backtrack(new StringBuilder(n), new StringBuilder(2 * n), wordDict, s, r);
        return new ArrayList<>(r);
    }

    public void backtrack(StringBuilder sb, StringBuilder path, List<String> wordDict, String target, HashSet<String> r) {
        if (target.indexOf(sb.toString()) != 0) return;
        else if (target.length() == sb.length() && target.equals(sb.toString())) {
            r.add(new String(path.substring(0, path.length() - 1)));
            return;
        } else if (target.length() < sb.length()) return;

        for (String word : wordDict) {
            sb.append(word);
            path.append(word + " ");
            backtrack(sb, path, wordDict, target, r);
            path.delete(path.length() - word.length() - 1, path.length());
            sb.delete(sb.length() - word.length(), sb.length());
        }
    }
}
