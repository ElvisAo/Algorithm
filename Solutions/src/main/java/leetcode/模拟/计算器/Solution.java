package leetcode.模拟.计算器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1 + 1"));
    }

    private int helper(Queue<Character> numQueue) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        char c;
        while (numQueue.size() > 0) {
            c = numQueue.poll();
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
//                continue;     // 为什么这里不能continue?因为这样最后一个数字就无法入栈
            }
            if (c == '(') {
                num = helper(numQueue);
            }
            if ((!isDigit(c) && c != ' ') || numQueue.isEmpty()) {
                // 前面两个！表示当前字符为运算符
                // isEmpty保证了最后一个数也能正常入栈
                switch (sign) {
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
                sign = c;
                num = 0;
            }
            if (c == ')') break;
        }
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        return sum;
    }

    public int calculate(String s) {
        s = s.trim();
        Queue<Character> numQueue = new LinkedList<>();
        for (char c : s.toCharArray()) numQueue.offer(c);
        return helper(numQueue);
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}

