package leetcode.数组.多数元素;

public class Solution {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int ele = nums[0], counter = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (counter == 0) {
                ele = nums[i];
                counter++;
                continue;
            }
            if (nums[i] == ele) counter++;
            else counter--;
        }
        return ele;
    }
}
