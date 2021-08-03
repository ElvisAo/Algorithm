package leetcode.动态规划.最长有效括号;

import java.util.Stack;


/**
 * TODO 尚未完成
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int solution_1(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = array[i];
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
            }
        }
        return 1;
    }
}
