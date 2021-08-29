package leetcode.字符串.反转字符串中的单词III;

public class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        int n = split.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = split[i].length() - 1; j >= 0; j--) {
                sb.append(split[i].charAt(j));
            }
            if (i != n - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
