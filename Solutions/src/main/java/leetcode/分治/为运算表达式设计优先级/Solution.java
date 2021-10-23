package leetcode.分治.为运算表达式设计优先级;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 241
 */
public class Solution {
    /**
     * 分治法，对于每个运算符，先把两边的结果算出来
     *
     * @param expression
     * @return
     */
    public List<Integer> solution_1(String expression) {
        List<Integer> list = new LinkedList<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solution_1(expression.substring(0, i));
                List<Integer> right = solution_1(expression.substring(i + 1, n));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) list.add(Integer.parseInt(expression)); // 这里其实算是递归出口，当只有一个数的时候
        return list;
    }

    HashMap<String, List<Integer>> memo = new HashMap<>();

    /**
     * 分治法+备忘录优化：效率极大提升
     *
     * @param expression
     * @return
     */
    public List<Integer> solution_2(String expression) {
        if (memo.containsKey(expression)) return memo.get(expression);
        int n = expression.length();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solution_2(expression.substring(0, i));
                List<Integer> right = solution_2(expression.substring(i + 1, n));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) list.add(Integer.parseInt(expression));
        memo.put(expression, list);
        return list;
    }
}
