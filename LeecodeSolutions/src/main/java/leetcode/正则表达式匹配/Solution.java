package leetcode.正则表达式匹配;

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

    public boolean isMatch(String str, String pattern) {
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
}