package leetcode.动态规划.最长有效括号;

import java.util.Stack;

/**
 * @see nowcoder.动态规划.最长的括号子串.Solution#solution_1(String)
 * leetcode 32
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

    /**
     * 栈：把(的索引或第一个不合法的索引入栈。每pop出一个(，即求出了一个合法的括号串，
     * 然后把当前的合法括号长度与已经取得的最长合法括号长度进行比较
     *
     * @param s
     * @return
     */
    public int solution_2(String s) {
        int ln = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int r = 0, cr;
        for (int i = 0; i < ln; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();    // caution：必须先pop
                if (stack.isEmpty()) stack.push(i); // 如果已经空了，说明当前就不合法，不用和r取最值
                else {  // 否则表示当前串是合法的，和r取最值
                    cr = i - stack.peek();
                    r = Math.max(cr, r);
                }
            }
        }
        return r;
    }
}
