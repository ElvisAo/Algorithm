package leetcode.模拟.计算器.Ⅰ_不考虑括号;

import java.util.Stack;

/**
 * {@注意对空格以及最后一个数字的判断}
 */
public class Exercise {
    public static void main(String[] args) {
        String s = " 3 / 2 ";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int num = 0;
        char c, symbol = '+';
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!isDigit(c) || i == n - 1) {
                if (c == ' ' && i != n - 1) continue;
                switch (symbol) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                symbol = c;
                num = 0;
            }
        }
        int r = 0;
        while (!stack.isEmpty()) {
            r += stack.pop();
        }
        return r;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
