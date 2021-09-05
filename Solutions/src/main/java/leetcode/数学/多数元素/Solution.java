package leetcode.数学.多数元素;

/**
 * leetcode 169
 */
public class Solution {
    /**
     * 如果不一定存在，则最后还要for一遍确认一下
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0], couter = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele) couter++;
            else {
                couter--;
                if (couter == 0) {
                    ele = nums[i];
                    couter = 1;
                }
            }
        }
        return ele;
    }
}
