package leetcode.动态规划.背包问题.分割等和子集_01背包;

import java.util.Arrays;

public class Solution {
    /**
     * {@转换为0-1背包问题}
     */
    public boolean solution_1(int[] nums) {
        int ln = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1 || ln < 2) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[ln + 1][target + 1];   // 前i个物品，能否将容量为j的背包装满
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= target; j++) {
                boolean not = dp[i - 1][j];
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = not;
                    continue;
                }
                boolean load = dp[i - 1][j - nums[i - 1]];
                dp[i][j] = not || load;
            }
        }
        return dp[ln][target];
    }

    /**
     * {@空间压缩}
     */
    public boolean solution_2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2, ln = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= ln; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    boolean not = dp[j];
                    boolean load = dp[j - nums[i - 1]];
                    dp[j] = not || load;
                }
            }
        }
        return dp[target];
    }
}
