package leetcode.栈.单调栈.每日温度;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] r = new int[n];
        r[n - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            r[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return r;
    }
}
