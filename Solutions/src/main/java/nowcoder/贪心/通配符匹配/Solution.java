/**
 * @author Everett
 * @date 7/1/2021 7:01 PM
 */
package nowcoder.贪心.通配符匹配;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_2("", "*?c"));
    }

    /**
     * {@动态规划}
     */
    public boolean solution_2(String s, String p) {
        int pln = p.length(), sln = s.length();
        boolean[][] dp = new boolean[pln + 1][sln + 1];
        dp[0][0] = true;    // 两个都为空的时候
        for (int i = 1; i <= pln; i++) {    // 处理pattern为纯*的情况
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= pln; i++) {
            for (int j = 1; j <= sln; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*') {
                    // 分别对应*匹配 0个、一个、多个的情况。对于多个时，表示某个位置上的*可以匹配到s串中某个点后面的多个字符
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }
        return dp[pln][sln];
    }

    /**
     * 递归+备忘录优化
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean solution_1(String str, String pattern) {
        return dp(str, pattern, 0, 0);
    }

    private boolean dp(String str, String pattern, int i, int j) {
        Tuple t = new Tuple(i, j);
        if (memo.containsKey(t)) return memo.get(t);
        if (j == pattern.length()) return i == str.length();
        if (i == str.length()) {
            for (int k = j; k < pattern.length(); k++)
                if (pattern.charAt(k) != '*') return false;
            return true;
        }
        boolean res = false;
        boolean single = (i < str.length()) && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?');    // 处理单个字符以及'.'

        if (pattern.charAt(j) == '*') {
            res = dp(str, pattern, i, j + 1) || dp(str, pattern, i + 1, j);
        } else {
            res = single && dp(str, pattern, i + 1, j + 1);
        }
        memo.put(new Tuple(i, j), res);
        return res;
    }

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
}
