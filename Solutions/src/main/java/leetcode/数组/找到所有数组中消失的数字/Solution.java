package leetcode.数组.找到所有数组中消失的数字;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> solution_1(int[] nums) {
        int n = nums.length;
        boolean helper[] = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            helper[nums[i]] = true;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) if (!helper[i]) list.add(i);
        return list;
    }

    public List<Integer> solution_2(int[] nums) {
        int n = nums.length, val;
        for (int i = 0; i < n; i++) {
            val = Math.abs(nums[i]);
            nums[val - 1] = -Math.abs(nums[val - 1]);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) if (nums[i] > 0) list.add(i);
        return list;
    }
}
