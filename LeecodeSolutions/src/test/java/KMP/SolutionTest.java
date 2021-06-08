package KMP;

class KMP {
    private int[][] dp;
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        this.dp = new int[pattern.length()][256];
        initDP();
    }

    private void initDP() {
        int X = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < pattern.length(); i++) {
            for (int c = 0; c < 256; c++) {
                if (pattern.charAt(i) == c) dp[i][c] = i + 1;
                else dp[i][c] = dp[X][c];
            }
            X = dp[X][pattern.charAt(i)];
        }
    }

    public int search(String str) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            j = dp[j][str.charAt(i)];
            if (j == pattern.length()) return i - j + 1;
        }
        return -1;
    }
}

public class SolutionTest {
    public static void main(String[] args) {
        String pattern = "abcdef";
        String str = "abcdeeabcdfabcdefghi";
        KMP kmp = new KMP(pattern);
        System.out.println(kmp.search(str));
        System.out.println(str.indexOf(pattern));
        System.out.println(kmp.search("oarbtravga af"));
    }
}
