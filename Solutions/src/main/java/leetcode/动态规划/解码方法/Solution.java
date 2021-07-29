package leetcode.动态规划.解码方法;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("2101"));
    }

    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        int ln = s.length();
        int[] dp = new int[ln + 1];
        dp[0] = 1;
        dp[1] = 1;
        int pre = s.charAt(0) - '0';
        for (int i = 2; i <= ln; i++) { // dp[i]：前i个字符
            int cur = s.charAt(i - 1) - '0';
            if (cur == 0) { // 当前为0
                if (pre == 1 || pre == 2) dp[i] = dp[i - 2];    // 如果前面是1或2，因为必须占用前面的数字，所以应该从i-2推过来
                else return 0;  // 否则返回0
            } else {    // 当前不为0
                int pc = pre * 10 + cur;    // 计算与前面数的组合的数
                if (pc < 10) dp[i] = dp[i - 1];     // 如果<10，说明前面是0
                else if (pc > 10 && pc <= 26) dp[i] = dp[i - 1] + dp[i - 2];    // 如果是两位合法的
                else dp[i] = dp[i - 1]; // 如果应该新起一位
            }
            pre = cur;
        }
        System.out.println(Arrays.toString(dp));
        return dp[ln];
    }
}
