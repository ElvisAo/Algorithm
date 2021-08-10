package leetcode.数组.除自身以外数组的乘积;

public class Solution {
    public int[] solution_1(int[] nums) {
        int n = nums.length;
        int[] preMulti = new int[n];
        int[] postMulti = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                preMulti[i] = 1;
            } else {
                preMulti[i] = preMulti[i - 1] * nums[i - 1];
            }

            int j = n - i - 1;
            if (j == n - 1) {
                postMulti[j] = 1;
            } else {
                postMulti[j] = postMulti[j + 1] * nums[j + 1];
            }
        }
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = preMulti[i] * postMulti[i];
        }
        return r;
    }

}
