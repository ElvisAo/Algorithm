package leetcode.动态规划.最长有效括号;

import java.util.Stack;

/**
 * @see nowcoder.动态规划.最长的括号子串.Solution#solution_1(String)
 */
public class Solution {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new Solution().solution_1(s));
    }

    /**
     * {@暴力法：超时}
     *
     * @param s
     * @return
     */
    public int solution_1(String s) {
        int n = s.length(), r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j += 2) {
                if (isValid(s, i, j)) r = Math.max(r, j - i + 1);
            }
        }
        return r;
    }

    private boolean isValid(String s, int i, int j) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int k = i; k <= j; k++) {
            c = s.charAt(k);
            if (c == '(') stack.push(c);
            else if (stack.isEmpty() || stack.pop() != '(') return false;
        }
        return stack.isEmpty();
    }
}
