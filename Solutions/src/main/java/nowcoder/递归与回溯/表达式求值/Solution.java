package nowcoder.递归与回溯.表达式求值;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve("1+2*3+(2-1)*4+(1-2*3)"));
    }

    public int solve(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) list.add(s.charAt(i));
        return helper(list);
    }

    private int helper(LinkedList<Character> list) {
        Stack<Integer> stack = new Stack<>();
        char symbol = '+';
        int num = 0;
        while (!list.isEmpty()) {
            char c = list.removeFirst();
            if (isDigit(c)) num = num * 10 + (c - '0');
            if (c == '(') {
                num = helper(list);
            }
            if (!isDigit(c) || list.isEmpty()) {
                switch (symbol) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-1 * num);
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
            if (c == ')') break;    // 这里必须放在最后，因为上面要对不是数字的case进行处理
        }
        int r = 0;
        while (!stack.isEmpty()) r += stack.pop();
        return r;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
