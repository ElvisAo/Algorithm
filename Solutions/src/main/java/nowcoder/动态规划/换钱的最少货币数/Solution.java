package nowcoder.动态规划.换钱的最少货币数;

import java.util.Arrays;

/**
 * 参见{@link leetcode.背包问题.零钱兑换_完全背包.Solution}
 */
public class Solution {
    public static void main(String[] args) {
        int[] money = {1494, 1525, 1295, 516, 3696, 1531, 4415, 3035, 4934, 1372, 3979, 2791, 2304, 2252, 4395, 3217, 3377, 4132, 2515, 333, 1587, 967, 2098, 4890, 2019, 1068, 698, 4383, 782, 678, 3886, 4037, 4836, 4762, 2387, 3391, 1670, 673, 764, 2335, 1579, 472, 4819};
        int aim = 4993;
        System.out.println(new Solution().solution_1(money, aim));
    }

    /**
     * 其实是背包问题
     * {@动态规划}
     *
     * @param arr
     * @param aim
     * @return
     */
    public int solution_1(int[] arr, int aim) {
        int ln = arr.length;
        int[][] dp = new int[ln + 1][aim + 1];
        for (int i = 0; i <= ln; i++) {
            Arrays.fill(dp[i], aim + 1);
            dp[i][0] = 0;   // 注意对0的初始化
        }

        for (int i = 1; i <= ln; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j - arr[i - 1] >= 0)    // 如果能放这件物品
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i - 1]] + 1);
                else dp[i][j] = dp[i - 1][j];   // 不放这件物品
            }
        }
        return dp[ln][aim] == aim + 1 ? -1 : dp[ln][aim];
    }

    /**
     * {@动态规划+空间压缩}
     *
     * @param arr
     * @param aim
     * @return
     */
    public int solution_2(int[] arr, int aim) {
        int ln = arr.length;
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 1; i <= ln; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j - arr[i - 1] >= 0)
                    dp[j] = Math.min(dp[j - arr[i - 1]] + 1, dp[j]);
            }
        }
        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }
}
