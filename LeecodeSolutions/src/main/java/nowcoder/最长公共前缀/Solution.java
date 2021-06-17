package nowcoder.最长公共前缀;

public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{"", "acbac"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        if (strs[0].length() == 0) return "";
        sb.append(strs[0].charAt(0));
        int i = 0;
        while (true) {
            for (String s : strs) {
                if (sb.length() > s.length() || sb.charAt(i) != s.charAt(i)) return sb.substring(0, i);
            }
            i++;
            if (i == strs[0].length()) return sb.toString();
            else sb.append(strs[0].charAt(i));
        }
    }
}
