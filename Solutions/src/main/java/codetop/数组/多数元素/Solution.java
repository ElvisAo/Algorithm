package codetop.数组.多数元素;

/**
 * leetcode 169
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int v = nums[0], counter = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (v != nums[i]) {
                counter--;
                if (counter == 0) {
                    v = nums[i];
                    counter++;
                }
            } else {
                counter++;
            }
        }
        return v;
    }
}
