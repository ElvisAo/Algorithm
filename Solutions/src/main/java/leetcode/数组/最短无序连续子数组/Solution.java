package leetcode.数组.最短无序连续子数组;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new Solution().solution_3(arr));
    }

    public int solution_1(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.stream(nums).forEach(x -> list.offer(x));
        list.sort((x, y) -> x - y);
        int i = 0, n = nums.length;
        while (i < n && list.getFirst() == nums[i++]) list.removeFirst();
        i = n - 1;
        while (i >= 0 && !list.isEmpty() && list.getLast() == nums[i--]) list.removeLast();
        return list.size();
    }

    public int solution_2(int[] nums) {
        int n = nums.length;
        int[] newNums = Arrays.copyOf(nums, n);
        Arrays.sort(newNums);
        int i = 0, j = n - 1;
        while (i < n && nums[i] == newNums[i]) i++;
        while (j > i && nums[j] == newNums[j]) j--;
        return j - i + 1;
    }

    /**
     * @param nums
     * @return
     * @{双向遍历}
     */
    public int solution_3(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (max <= nums[i]) max = nums[i];
            else l = i;     // l：找最右边应该重新排序的
        }
        for (int j = n - 1; j >= 0; j--) {
            if (min >= nums[j]) min = nums[j];
            else r = j; // r：找最左边应该重新排序的
        }
        if (l == 0 && r == n - 1) return 0;     // 如果l和r都没有被更新，说明是有序的
        return l - r + 1;
    }
}
