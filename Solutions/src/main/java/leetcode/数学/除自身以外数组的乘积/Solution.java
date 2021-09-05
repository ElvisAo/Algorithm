package leetcode.数学.除自身以外数组的乘积;

/**
 * leetcode 138
 * 可以参考{@link leetcode.数组.分发糖果.Solution}
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preMulti = new int[n + 1], postMulti = new int[n + 1];
        preMulti[0] = postMulti[n] = 1;
        for (int i = 1; i <= n; i++) {  // pre[1] = nums[0]，没有包括第i个，pre[n] = pres[n-1]*nums[n-1]
            preMulti[i] = preMulti[i - 1] * nums[i - 1];

            int j = n - i;
            postMulti[j] = postMulti[j + 1] * nums[j];  // post[j]包括了nums[j]，如果要不包括你nums[j]，就应该算post[j+1]
        }
        int[] r = new int[n];
        r[0] = postMulti[0];
        r[n - 1] = preMulti[n];
        for (int i = 1; i < n - 1; i++) {
            r[i] = preMulti[i] * postMulti[i + 1];
        }
        return r;
    }
}
