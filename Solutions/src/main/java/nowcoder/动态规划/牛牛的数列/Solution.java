package nowcoder.动态规划.牛牛的数列;

/**
 * TODO 对开头结尾的变换还没处理
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3, 3, 2, 1};
        System.out.println(new Solution().solution_1(nums));
    }

    public int solution_1(int[] nums) {
        int n = nums.length, r = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        int old_r = 0;
        boolean changed = false;
        /**
         * {@从左到右，从右到左分别计算两次递增序列}
         */
        for (int i = 1; i < n; i++)
            left[i] = nums[i] > nums[i - 1] ? left[i - 1] + 1 : 1;
        for (int i = n - 2; i >= 0; i--)
            right[i] = nums[i] < nums[i + 1] ? right[i + 1] + 1 : 1;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i + 1] - 1) {
                old_r = r;
                r = Math.max(r, left[i - 1] + right[i + 1] + 1);
                if (nums[i] <= nums[i - 1]) changed = true;
                if (old_r != r) changed = false;
            }
        }
        if (!changed) {
            r = Math.max(Math.max(right[1], left[n - 2]) + 1, r);
        }
        return r;
    }
}
