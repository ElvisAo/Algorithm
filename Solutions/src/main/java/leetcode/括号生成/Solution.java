package leetcode.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static ArrayList<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(n), 0, 0);
        return list;
    }


    private void backtrack(int n, StringBuilder sb, int left, int right) {
        if (left < right || left + right > 2 * n) return;
        if (left == right && left + right == 2 * n) {
            list.add(new String(sb));
            return;
        }
        char[] bracket = new char[]{'(', ')'};
        for (char c : bracket) {
            sb.append(c);
            if (c == '(')
                backtrack(n, sb, left + 1, right);
            else backtrack(n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(3);
        for (String s : list)
            System.out.println(s);
    }
}
