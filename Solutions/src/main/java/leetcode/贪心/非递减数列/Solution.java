package leetcode.贪心.非递减数列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 6};
        System.out.println(new Solution().checkPossibility(nums));
    }

    /**
     * 动态规划：转换为求最长递增子序列的长度，如果>=n-1，则可以
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int r = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            r = Math.max(r, dp[i]);
        }
        return r >= n - 1;
    }

    /**
     * 这道题给了我们一个数组，说我们最多有1次修改某个数字的机会，
     * 问能不能将数组变为非递减数组。题目中给的例子太少，不能覆盖所有情况，我们再来看下面三个例子：
     * 4，2，3
     * -1，4，2，3
     * 2，3，3，2，4
     * 我们通过分析上面三个例子可以发现，当我们发现后面的数字小于前面的数字产生冲突后，
     * [1]有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
     * [2]有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，
     * 那么有什么内在规律吗？是有的，判断修改那个数字其实跟再前面一个数的大小有关系，
     * 首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
     * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
     * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
     *
     * @param nums
     * @return
     */
    public boolean solution_2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
