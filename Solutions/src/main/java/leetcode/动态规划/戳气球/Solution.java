package leetcode.动态规划.戳气球;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * leetcode 312
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        int[] nums = {7, 1, 6, 8, 2, 9, 4};
        System.out.println(new Solution().solution_2(nums));
    }

    private int res;

    /**
     * 回溯法：超时
     *
     * @param nums
     * @return
     */
    public int solution_1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        backtrack(list, 0);
        return res;
    }

    private void backtrack(ArrayList<Integer> list, int score) {
        if (list.size() == 0) res = Math.max(res, score);
        else {
            for (int i = 0; i < list.size(); i++) {
                int ele = list.get(i);
                int point = (i - 1 < 0 ? 1 : list.get(i - 1)) * ele * (i + 1 > list.size() - 1 ? 1 : list.get(i + 1));
                list.remove(i);
                backtrack(list, score + point);
                list.add(i, ele);
            }
        }
    }

    /**
     * {@动态规划}
     *
     * @param nums
     * @return
     */
    private int solution_2(int[] nums) {
        int ln = nums.length;
        int[] p = new int[ln + 2];
        p[0] = 1;
        p[ln + 1] = 1;
        for (int i = 1; i < ln + 1; i++) p[i] = nums[i - 1];

        // i和j就是两个状态，最后戳破哪一个气球就是选择
        int[][] dp = new int[ln + 2][ln + 2];   // dp[i][j]：戳破i和j之间的所有气球，可以获得的最大分数，不包括i和j
        for (int i = ln; i >= 0; i--) {     // 斜着求：从下往上
            for (int j = i + 1; j < ln + 2; j++) {  // 斜着求：从左到右
                for (int k = i + 1; k < j; k++) {   // 最后戳破哪个气球
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + p[i] * p[k] * p[j]);
                    // 状态dp[i][j]依赖与dp[i][k]和dp[k][j]；所以在计算ij前，ik和kj必须被计算出来
                    // 怎么保证？
                    // dp[i][j]是i行j列；dp[i][k]是i行k列；dp[k][j]是k行j列
                    // 其中：i<k<j，即始终是行号小于列号的区域，即dp数组的右上部分。所以i<k<j时，dp[i][k],dp[k][j]已经求出来了，因为是从下到上，从左到右计算的
                    // 最终要求的是dp[0][ln+2]，所以可以从下往上，从左往右计算
                }
            }
        }
        return dp[0][ln + 1];
    }
}
