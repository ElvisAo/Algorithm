package leetcode.动态规划.一到n中一的出现次数;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(new Exercise().solution(100));
    }

    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int r = 1;
        for (int i = 10; i <= n; i++) {
            dp[i] = dp[i / 10] + (i % 10 == 1 ? 1 : 0);
            r += dp[i];
        }
        return r;
    }
}
