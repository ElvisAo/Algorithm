package LeetCode热题HOT100.正则表达式匹配;

public class Solution {
    public static void main(String[] args) {
        String s = "aa", p = "a*";
        System.out.println(new Solution().solution_3(s, p));
    }

    /***
     * {@效率略低}
     * @param s
     * @param p
     * @return
     */
    public boolean solution_1(String s, String p) {
        if (p == null || (s.length() != 0 && p.length() == 0)) return false;    // s没有完但是p完了
        if (s.equals(p)) return true;
        boolean match = (s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return solution_1(s, p.substring(2)) || (match && solution_1(s.substring(1), p));
        } else return match && solution_1(s.substring(1), p.substring(1));
    }

/*    public boolean solution_2(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int i, String p, int j) {
        int sln = s.length(), pln = p.length();
        if ((i >= sln && j < pln) || (i < sln && j >= pln)) return false;
        if(s.substring(i).equals(p.substring(j)))return true;
        boolean singleMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
        if (j + 1 < pln && p.charAt(j + 1) == '*') {
            */

    /**
     * {@前面部分：*前面字符出现零次，所以不考虑当前匹配的情况，p串跳过当前字符和*}
     * {@后面部分：*前面字符出现一次或多次，所以如果p串下一个是*，s串不能移动，考虑前面——也就是当前字符的匹配情况}
     *//*
            return helper(s, i, p, j + 2) || (singleMatch && helper(s, i + 1, p, j));
        } else return singleMatch && helper(s, i + 1, p, j + 1);
    }*/
    public boolean solution_3(String s, String p) {
        int sln = s.length(), pln = p.length();
        int[][] dp = new int[pln + 1][sln + 1];
        for (int i = 1; i <= sln; i++) {
            for (int j = 1; j <= pln; j++) {
                if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') {
//                    dp[i][j] = dp[i-1][j-1]+
                }
            }
        }
        return false;
    }
}
