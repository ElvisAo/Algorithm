package 四键键盘;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_2(7));
    }

    private int solution_1(int n) {
        return helper(n, 0, 0);
    }

    private HashMap<String, Integer> memo = new HashMap<>();

    /**
     * @param rema：剩余的击键次数
     * @param a_num：屏幕上a的数量
     * @param a_buffer：缓冲区a的数量
     * @return
     */
    private int helper(int rema, int a_num, int a_buffer) {
        if (rema <= 0) return a_num;
        String key = "" + rema + a_num + a_buffer;
        if (memo.containsKey(key)) return memo.get(key);
        int a_trick = helper(rema - 1, a_num + 1, a_buffer);
        int cv_trick = helper(rema - 1, a_num + a_buffer, a_buffer);
        int cacv_trick = helper(rema - 2, a_num, a_num);
        int r = Math.max(
                Math.max(a_trick, cv_trick),
                cacv_trick
        );
        memo.put(key, r);
        return r;
    }

    private int solution_2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++)
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));   // j-2，表示ctrl-a, ctrl-c，然后连续按了i-j+1次ctrl-v
        }
        return dp[n];
    }
}
