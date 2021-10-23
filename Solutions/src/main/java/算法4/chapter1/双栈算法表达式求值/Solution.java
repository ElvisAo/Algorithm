package 算法4.chapter1.双栈算法表达式求值;

import java.util.Stack;

/**
 * 非通用，只能对（val1 op val2）类型的表达式求值
 */
public class Solution {
    public static void main(String[] args) {
        String s = "(1+((2+3)*(4*5)))";
        System.out.println(new Solution().calculate(s));
    }

    public double calculate(String expr) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        char[] arr = expr.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c);
                    break;
                case '(':
                    break;
                case ')':
                    char op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case '+':
                            v = vals.pop() + v;
                            break;
                        case '-':
                            v = vals.pop() - v;
                            break;
                        case '*':
                            v = vals.pop() * v;
                            break;
                        case '/':
                            v = vals.pop() / v;
                            break;
                    }
                    vals.push(v);
                    break;
                default:
                    vals.push(Double.parseDouble(c + ""));
            }
        }
        return vals.pop();
    }
}
