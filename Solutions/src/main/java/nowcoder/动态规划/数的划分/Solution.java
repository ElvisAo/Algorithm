package nowcoder.动态规划.数的划分;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
/*        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l2.add(1);
        System.out.println(l1.equals(l2));  // true*/

        System.out.println(new Solution().solution_1(5, 2));
    }

    /**
     * {@回溯：超时}
     *
     * @param n
     * @param k
     * @return
     * @描述 把数n分为k分，任意一份不能为0
     */
    public int solution_1(int n, int k) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        backtrack(n, k, set, new ArrayList<Integer>());
        return set.size();
    }

    private void backtrack(int n, int k, HashSet<ArrayList<Integer>> used, ArrayList<Integer> path) {
        if (k == 0) {
            if (n == 0) {
                ArrayList<Integer> t = new ArrayList<>(path);
                Collections.sort(t);
                used.add(t);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            path.add(i);
            backtrack(n - i, k - 1, used, path);
            path.remove(path.size() - 1);
        }
    }

    /**
     * {@动态规划}
     *
     * @param n
     * @param k
     * @return
     */
    public int solution_2(int n, int k) {
        int[][] dp = new int[n + 1][k + 1]; // dp[i][j]：把i分为k份的方式数
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                /**
                 * 1.j份中至少一个是1，方案数为f(i-1,j-1)
                 * 2.j份中一份1都没有，考虑将i-j分为j份，再往j份中的每一份+1，方案数为f(i-j,j）
                 */
                if (i >= j)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
            }
        }
        return dp[n][k];
    }

}
