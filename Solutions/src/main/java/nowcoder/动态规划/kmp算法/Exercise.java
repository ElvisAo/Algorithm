package nowcoder.动态规划.kmp算法;


class KMPExer {
    private String pattern;
    private int n;
    private int[][] dp;
    private boolean count;

    public KMPExer(String pattern, boolean count) {
        this.pattern = pattern;
        this.n = pattern.length();
        this.count = count;
        if (count) {
            dp = new int[n + 1][256];
            init(count);
        } else {
            dp = new int[n][256];
            init();
        }
    }

    private void init(boolean count) {
        int X = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 256; j++)
                dp[i][j] = dp[X][j];
            dp[i][pattern.charAt(i)] = i + 1;
            X = dp[X][pattern.charAt(i)];
        }
        dp[n][pattern.charAt(n - 1)] = X;
    }

    /***
     * 计算模板串在s串中出现的次数
     * @param s 被搜索的串
     * @return 模板串在s串中的出现次数
     * @throws Exception
     */
    public int count(String s) throws Exception {
        if (!count) throw new Exception("Not Supported Operation");
        int j = 0, m = s.length(), r = 0;
        for (int i = 0; i < m; i++) {
            j = dp[j][s.charAt(i)];
            if (j == n) {
                r++;
                j = dp[j][n];
            }
        }
        return r;
    }

    private void init() {
        int X = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 256; c++)
                dp[i][c] = dp[X][c];
            dp[i][pattern.charAt(i)] = i + 1;
            X = dp[X][pattern.charAt(i)];
        }
    }


    /**
     * 在s串中搜索模板串，并返回模板串在s串中的开始位置
     *
     * @param s 被搜索代串
     * @return int 模板串在s串中的开始位置
     * @throws Exception
     */
    public int search(String s) throws Exception {
        if (count) throw new Exception("Not Supported Operation");
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = dp[j][s.charAt(i)];     // 注意：这里应该取s.charAt，而不是pattern的
            if (j == n) {
                // 注意：这里是j==n时返回，因为当匹配到最后一个字符后，由上面init中的dp[i][pattern.charAt(i)]=i+1，j会变为pattern.length;
                return i - j + 1;
            }
        }
        return -1;
    }
}

public class Exercise {
    public static void main(String[] args) throws Exception {
        String s = "abcdbdbc", pattern = "dbd";
        KMPExer KMP = new KMPExer(pattern, false);
        System.out.println(KMP.search(s));
    }
}
