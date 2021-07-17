package nowcoder.动态规划.最长的括号子串;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        String s = "()()(()())((()()";
        System.out.println(new Solution().solution_3(s));
    }

    public int solution_1(String s) {
        int ln = s.length();
        int[] dp = new int[ln];     // dp[i]：以i结尾的有效子字符串的长度
        int r = 0;
        for (int i = 1; i < ln; i++) {
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                r = Math.max(r, dp[i]);
            }
        }
        return r;
    }

    public int solution_2(String s) {
        int ln = s.length(), cur_length = 0, max_length = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1); // 入栈-1，栈底的元素表示匹配串的起始索引的前一位
        for (int i = 0; i < ln; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i); // 表示i已经不匹配，所以才会把栈底的元素都pop出来，然后这个i就是一个“区分”
                else {
                    cur_length = i - stack.peek();
                    max_length = Math.max(cur_length, max_length);
                }
            }
        }
        return max_length;
    }

    /**
     * {@括号匹配的本质：(数量>)数量，可能合法，继续判断；(数量<)数量，一定不合法}
     * 可以结合 {@link nowcoder.递归与回溯.括号生成.Solution 来看}
     */
    public int solution_3(String s) {
        int ln = s.length(), left = 0, right = 0, max_length = 0;
        for (int i = 0; i < ln; i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) max_length = Math.max(max_length, 2 * left);
            if (right > left) left = right = 0;
        }
        return max_length;
    }
}
