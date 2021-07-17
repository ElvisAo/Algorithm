package nowcoder.字符串.最长重复子串;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * {@超时}
     *
     * @param a
     * @return
     */
    public int solution_1(String a) {
        int n = a.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String sub = a.substring(i, j + 1);
                String t = new String(sub);
                sub += sub;
                while (a.contains(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                    sub += t;
                }
            }
        }
        return maxLen;
    }

    /**
     * {@二分法思想}
     *
     * @param a
     * @return
     */
    public int solution_2(String a) {
        // write code here
        if (a == null || a.length() < 2) return 0;
        char[] s = a.toCharArray();
        int len = s.length;
        for (int gap = len / 2; gap >= 1; gap--) {
            for (int start = 0; start <= len - 2 * gap; ) {
                int res = check(s, start, gap);
                if (res == -1) return 2 * gap;
                else start = res + 1;   // 返回值如果不为-1，表示前面的匹配了一部分，从res开始不匹配，所以从后面一个开始匹配即可
            }
        }
        return 0;
    }

    public int check(char[] s, int start, int len) {
        for (int i = start; i < start + len; i++) {
            if (s[i] != s[i + len]) return i;
        }
        return -1;
    }
}
