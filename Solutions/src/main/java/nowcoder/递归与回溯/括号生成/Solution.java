/**
 * @author Everett
 * @date 6/29/2021 10:36 AM
 */
package nowcoder.递归与回溯.括号生成;

import java.util.ArrayList;

/**
 * 注意，不能使用栈来对括号的合法性进行判断，因为涉及到回溯（在撤销选择的时候本来就应该出栈），
 * 如果使用栈对括号的合法性进行判断，则在遇到')'的时候，就会导致元素提前出栈，与撤销选择时的出栈不可兼得
 * {@所以必须使用剩余的左括号与右括号数量来判断}
 */
public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new Solution().generateParenthesis(4);
        for (String s : list) System.out.println(s);
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder path = new StringBuilder(n);
        helper(n, n, path, list);
        return list;
    }

    /**
     * {@一个关键点在于记录的是某边括号的剩余数}
     *
     * @param left
     * @param right
     * @param path
     * @param list
     */
    private void helper(int left, int right, StringBuilder path, ArrayList<String> list) {
        // 剩余的左括号多，不合法；某个括号剩余的为负数时不合法
        if (left > right || (left < 0 || right < 0)) return;
        if (left == 0 && right == 0) list.add(path.toString()); // 左右括号刚好用完，合法

        path.append('(');
        helper(left - 1, right, path, list);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        helper(left, right - 1, path, list);
        path.deleteCharAt(path.length() - 1);
    }
}
