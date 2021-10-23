package leetcode.数组.第三大的数;

import java.util.Arrays;

/**
 * leetcode 414
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1};
        System.out.println(new Solution().solution_2(arr));
    }

    public int solution_1(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
        if (arr.length < 3) return arr[arr.length - 1];
        else return arr[arr.length - 3];
    }

    public int solution_2(int[] nums) {
        int[] res = deduplicate(nums);
        int n = res.length;
        if (n < 3) return res[n - 1];
        else return res[n - 3];
    }

    private int[] deduplicate(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        int i = 0, j = 1;
        while (j < n) {
            if (arr[i] == arr[j]) j++;
            else arr[++i] = arr[j++];
        }
        return Arrays.copyOf(arr, i + 1);
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) hi--;
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] < pivot) lo++;
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }
}
