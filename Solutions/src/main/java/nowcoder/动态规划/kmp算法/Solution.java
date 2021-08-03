/**
 * @author Everett
 * @date 6/29/2021 9:40 AM
 */
package nowcoder.动态规划.kmp算法;

class KMP {
    private String pattern;
    private int[][] dp;
    private int n;

    public KMP(String pattern) {
        this.pattern = pattern;
        this.n = pattern.length();
        this.dp = new int[n + 1][256];
        init();
    }

    // 如果找到子串出现的次数，则在计算基本的j外，还需要额外算匹配完之后，模式串的j还要回到影子状态
    private void init() {
        int X = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 256; c++) {
                if (c == pattern.charAt(i)) dp[i][c] = i + 1;
                else dp[i][c] = dp[X][c];
            }
            X = dp[X][pattern.charAt(i)];
        }
        dp[n][pattern.charAt(n - 1)] = X;
    }

    public int search(String str) {
        int ln = str.length();
        int j = 0;
        int r = 0;
        for (int i = 0; i < ln; i++) {
            j = dp[j][str.charAt(i)];
            if (j == n) {
                r++;
                j = dp[j][str.charAt(i)];
            }
        }
        return r;
    }
}

public class Solution {
    public static void main(String[] args) {
        String pattern = "aabaa";
        String str = "aabaabaa";
        System.out.println(new Solution().kmp(pattern, str));
    }

    public int kmp(String S, String T) {
        KMP kmp = new KMP(S);
        return kmp.search(T);
    }
}
