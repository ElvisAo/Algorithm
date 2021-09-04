package leetcode.动态规划.正则表达式匹配;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    class Tuple {
        int first, second;

        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return first == tuple.first &&
                    second == tuple.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private HashMap<Tuple, Boolean> memo = new HashMap<>();

    public boolean solution_1(String str, String pattern) {
        return dp(str, pattern, 0, 0);
    }

    private boolean dp(String str, String pattern, int i, int j) {
        Tuple t = new Tuple(i, j);
        if (memo.containsKey(t)) return memo.get(t);
        if (j == pattern.length()) return i == str.length();
        boolean res;
        boolean single = (i < str.length()) && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');    // 处理单个字符以及'.'
        if (j <= pattern.length() - 2 && pattern.charAt(j + 1) == '*') {    // 如果下一个是*
            res = dp(str, pattern, i, j + 2) || (single && dp(str, pattern, i + 1, j));   // 分别对应*匹配零个与多个的情况
        } else res = single && dp(str, pattern, i + 1, j + 1);
        memo.put(new Tuple(i, j), res);
        return res;
    }

    public boolean solution_2(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++)
            if (p.charAt(i - 1) == '*')  // 第i个字符对应的是下标i-1，然后放在了dp[x][i]位置
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.') {   // 如果当前字符为.，则看之前的匹配结果
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) != '*') {  // 如果当前字符不等于.和*，那么就看当前字符是否匹配以及之前的结果
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);

                    // 下面都是当前字符为*的情况
                } else {
                    // 如果前一个字符如果不能匹配多个：前一个字符只能使用之前的那一次，在后面不能再使用
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                        // 包括 p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'，即前一个字符能够进行多次匹配
                    } else {
                        /**
                         * TODO 待完全理解
                         */
                        // 要么，要么前一个字符匹配一个，要么前面那个字符匹配0个
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][m];
    }

    /**
     * {@ldbuladong}
     *
     * @param s
     * @param p
     * @return
     */
    public boolean solution_3(String s, String p) {
        return helper(s, 0, p, 0);
    }

    HashMap<String, Boolean> memo_map = new HashMap<>();

    private boolean helper(String s, int i, String p, int j) {
        int n = s.length(), m = p.length();
        // base case
        if (j == m) return i == n;  // 两个都已经匹配完了
        else if (i == n) {  // s串已经走完了，看p能否匹配空串
            // 如果能匹配空串，则一定是字符和*成对出现
            if ((m - j) % 2 == 1) return false;
            else {
                for (; j + 1 < m; j += 2) {
                    if (p.charAt(j + 1) != '*') return false;
                }
            }
            return true;
        }
        String key = i + "" + j;
        if (memo_map.containsKey(key)) return memo_map.get(key);
        boolean r = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // 当前能匹配
            // 如果p的下一个是*
            if (j < m - 1 && p.charAt(j + 1) == '*') {
                // 匹配多个或0个
                r = helper(s, i + 1, p, j) || helper(s, i, p, j + 2);
            } else {    // 否则只能匹配一个
                r = helper(s, i + 1, p, j + 1);
            }
        } else {    // 当前不能匹配
            // p的下一个是*，只能匹配0个
            if (j < m - 1 && p.charAt(j + 1) == '*') {
                r = helper(s, i, p, j + 2);
            } else {
                return r = false;
            }
        }
        memo_map.put(key, r);
        return r;
    }
}