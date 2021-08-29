package leetcode.模拟.计算器.Ⅱ_考虑括号;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "1 + 2 *(2+ 5 )-13/2";
        System.out.println(new Solution().calculate(s));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) list.add(c);
        return helper(list);
    }

    private int helper(LinkedList<Character> list) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char c, sign = '+';
        while (!list.isEmpty()) {
            c = list.poll();
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!isDigit(c) || list.isEmpty()) {
                if (c == ' ' && !list.isEmpty()) continue;  // 跳过空格
                /**
                 * {@值得思考：为什么这里是让num=递归的结果？}
                 * 因为在(之前，必然是运算符号，即，已经进行过一轮运算了，当前的num==0，而且对于前面的运算符，是要对递归的结果进行计算的
                 */
                if (c == '(') num = helper(list);
                switch (sign) {     // 注意：是根据之前的符号，而不是当前的符号来判断怎么计算
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
                if (c == ')') break;
                sign = c;
                num = 0;
            }
        }
        int r = 0;
        while (!stack.isEmpty()) r += stack.pop();
        return r;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
