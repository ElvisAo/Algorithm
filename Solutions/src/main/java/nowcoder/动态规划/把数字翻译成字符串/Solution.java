package nowcoder.动态规划.把数字翻译成字符串;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().isLegal("26"));
//        System.out.println("0".substring(3, 5));
        String s = "31717126241541717";
        for (int i = 1; i <= s.length(); i++)
            System.out.println(new Solution().solution_1(s.substring(0, i)) + ":" + new Solution().solution_2(s.substring(0, i)));
    }

    /**
     * {@回溯法+备忘录优化}
     *
     * @param nums
     * @return
     */
    public int solution_1(String nums) {
        return back(nums, 0);
    }

    HashMap<Integer, Integer> memo = new HashMap<>();

    private int back(String s, int i) {
        if (i >= s.length()) return 1;
        if (memo.containsKey(i)) return memo.get(i);
        boolean single = s.charAt(i) > '0' && s.charAt(i) <= '9';
        boolean doubl = i <= s.length() - 2 && s.charAt(i) != '0' && isLegal(s.substring(i, i + 2));
        int r = 0;
        if (single) r += back(s, i + 1);
        if (doubl) r += back(s, i + 2);
        memo.put(i, r);
        return r;
    }

    private boolean isLegal(String s) {
        return "00".compareTo(s) < 0 && "27".compareTo(s) > 0;
    }

    /**
     * {@动态规划}
     *
     * @param nums
     * @return
     * @demo 1010123->3
     */
    public int solution_2(String nums) {
        if (nums.length() == 0 || nums.charAt(0) == '0')
            return 0;
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums.charAt(i) != '0') dp[i] = dp[i - 1];   // 处理单个字符
            int num = (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0');
            if (num >= 10 && num <= 26) {   // 处理两个字符
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];     // 当时主要是这里dp[i]的状态转移没搞清楚，以为是dp[i-1]*2;
                }
            }
        }
        return dp[nums.length() - 1];
    }
}
