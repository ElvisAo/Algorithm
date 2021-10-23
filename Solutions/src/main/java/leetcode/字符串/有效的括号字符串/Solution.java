package leetcode.字符串.有效的括号字符串;

import java.util.Stack;

/**
 * leetcode 678
 * 用两个栈分别记录star和left的索引，从而在最后计算*(的情况
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "((())", s2 = "(()))", s3 = "*))()", s4 = "(*())", s5 = "*(";
        String s = "(((((*(((((*((**(((*)*((((**))*)*))))))))((*(((((**(**)";
        System.out.println(checkValidString(s1));
        System.out.println(checkValidString(s2));
        System.out.println(checkValidString(s3));
        System.out.println(checkValidString(s4));
        System.out.println(checkValidString(s5));
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> star = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') star.push(i);
            else if (c == ')') {
                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }
        while (!star.isEmpty() && !left.isEmpty()) {
            if (star.pop() < left.pop()) return false;
        }
        if (!left.isEmpty()) return false;
        return true;
    }
}
