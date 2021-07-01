package mp;

class KMP {
    private String pattern;
    private int[][] dp; // 注意：这里是int才有默认值0，如果是包装类，默认值是null
    private Integer size;

    public KMP(String pattern) {
        this.pattern = pattern;
        this.size = pattern.length();
        this.dp = new int[this.size][256];
        init();
    }

    private void init() {
        int x = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < size; i++) {
            for (int c = 0; c < 256; c++) {
                if (pattern.charAt(i) == c) dp[i][c] = i + 1;
                else dp[i][c] = dp[x][c];
            }
            x = dp[x][pattern.charAt(i)];
        }
    }

    public int search(String s) {
        int j = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {    // 主串不回溯
            j = dp[j][s.charAt(i)];
            if (j == pattern.length()) {
                r++;    // 注意：这里是pattern.length，把模式串匹配完即可
                j = dp[i+1][pattern.charAt(i)];
            }
        }
        return r;
    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kmp("ababab", "abababab"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算模板串S在文本串T中出现了多少次
     *
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public int kmp(String S, String T) {
        // write code here  "ababab", "abababab"
        int r = 0, j;
        KMP kmp = new KMP(S);
        /*for (int i = 0; i <= T.length() - S.length(); i++) {
            if ((j = kmp.search(T.substring(i))) >= 0) {
                r++;
                i += j;
            }
        }*/
        r = kmp.search(T);
        return r;
    }
}