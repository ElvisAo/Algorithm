package leetcode.字符串.去除重复字母;

import java.util.LinkedList;

/**
 * leetcode 316、1081
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abbcabd";
        System.out.println(new Solution().removeDuplicateLetters(s));
    }

    /**
     * 思想：
     * 利用单调栈来保证有序
     * 先统计每个字符的个数
     * 然后在进行单调栈的pop时，先看后面还有没有该元素，如果有，则可以“考虑”pop，否则就不能pop
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        int n = s.length();
        char c;
        for (int i = 0; i < n; i++) count[s.charAt(i)]++;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            count[c]--;
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peekLast() > c) {
                if (count[stack.peekLast()] == 0) break;
                inStack[stack.pollLast()] = false;
            }
            stack.addLast(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) sb.append(stack.pollFirst());
        return sb.toString();
    }
}
