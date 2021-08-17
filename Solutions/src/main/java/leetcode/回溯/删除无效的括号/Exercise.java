package leetcode.回溯.删除无效的括号;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        String s = "()())()";
        new Exercise().removeInvalidParentheses(s).stream().forEach(x -> System.out.println(x));
    }

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int leftRemove = 0, rightRemove = 0;
        for (int i = 0; i < n; i++) {
            if (charArray[i] == '(') leftRemove++;
            else if (charArray[i] == ')') {
                if (leftRemove > 0) leftRemove--;
                else rightRemove++;
            }
        }
        HashSet<String> set = new HashSet<>();
        StringBuilder path = new StringBuilder(n);
        backtrack(charArray, 0, 0, 0, leftRemove, rightRemove, set, path);
        return new ArrayList<>(set);
    }

    private void backtrack(char[] charArray, int index, int leftCount, int rightCount, int leftRemove, int rightRemove, HashSet<String> set, StringBuilder path) {
        if (leftCount < rightCount) return;
        if (index == charArray.length) {
            if (leftRemove == 0 && rightRemove == 0) {
                set.add(path.toString());
            }
            return;
        }
        char c = charArray[index];
        // 1. 删除当前，因为是删除，所以不更新leftCount和rightCount
        if (c == '(' && leftRemove > 0)
            backtrack(charArray, index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, set, path);
        else if (c == ')' && rightRemove > 0)
            backtrack(charArray, index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, set, path);

        // 2. 不删除当前
        path.append(c);
        if (c == '(')
            backtrack(charArray, index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, set, path);
        else if (c == ')')
            backtrack(charArray, index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, set, path);
        else backtrack(charArray, index + 1, leftCount, rightCount, leftRemove, rightRemove, set, path);
        path.deleteCharAt(path.length() - 1);
    }
}
