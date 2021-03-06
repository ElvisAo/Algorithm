package Labuladong及巧妙算法.KMP;

class KMP {
    private int[][] dp;
    private String pattern;
    int n;

    public KMP(String pattern) {
        this.pattern = pattern;
        n = pattern.length();
        this.dp = new int[n + 1][256];
        initDP();
    }

    private void initDP() {
        int X = 0;  // 影子状态，即X和i具有相同的前缀
        dp[0][pattern.charAt(0)] = 1;   // 只有第一个字母匹配了，才能往后面走
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 256; c++) {
                if (pattern.charAt(i) == c) dp[i][c] = i + 1;
                else dp[i][c] = dp[X][c];   // 如果不匹配，委托给影子状态，即：进行最小回退
            }
            X = dp[X][pattern.charAt(i)];   // 在里面有dp[i][c]的更新，这里的dp[X][pattern.charAt(i)]其实已经处理过了
            // 这里主要是推进影子状态
        }
        dp[n][pattern.charAt(n - 1)] = X;
    }

    public int indexOf(String str) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            // 只有匹配到pattern的第一个字母，状态才能推进（j才能开始往后走）；否则i往后移
            // dp[i][c] == next，表明了pattern中的状态该如何转移
            j = dp[j][str.charAt(i)];
            if (j == n) return i - j + 1;
        }
        return -1;
    }

    public int count(String str) {
        int j = 0, r = 0;
        for (int i = 0; i < str.length(); i++) {
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
        String str = "abaaababab";
        String pattern = "bab";
        KMP kmp = new KMP(pattern);
        System.out.println(kmp.indexOf(str));
        System.out.println(str.indexOf(pattern));
    }
}
