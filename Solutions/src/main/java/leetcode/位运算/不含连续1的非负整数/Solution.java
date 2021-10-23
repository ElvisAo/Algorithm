package leetcode.位运算.不含连续1的非负整数;

/**
 * TODO 待完成
 */
public class Solution {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().solution_2(n));
    }

    /**
     * 超空间
     *
     * @param n
     * @return
     */
    public int solution_1(int n) {
        int counter = 2;
        if (n == 1) return counter;
        boolean[] dp = new boolean[n + 1];  // dp[i]：i是否有连续的1
        // i==0 和 i==1 都是false
        for (int i = 2; i <= n; i++) {
            boolean last_1 = ((i & 1) == 1);    // i是以1结尾？
            // 先判断最后的两位是不是连续的1
            boolean last_2 = (((i >> 1) & 1) == 1); // 倒数第二位是不是1?
            if (dp[i >> 1] || (last_1 && last_2)) {
                dp[i] = true;
            } else {
                counter++;
            }
        }
        return counter;
    }

    /**
     * 超时间
     *
     * @param n
     * @return
     */
    public int solution_2(int n) {
        int counter = 2;
        if (n == 1) return counter;
        for (int i = 2; i <= n; i++) {
            if ((i & (i >> 1)) == 0) {
                counter++;
            }
        }
        return counter;
    }

}
