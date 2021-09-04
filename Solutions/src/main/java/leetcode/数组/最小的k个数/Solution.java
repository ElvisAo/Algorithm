package leetcode.数组.最小的k个数;

import java.util.Arrays;

public class Solution {
    public int[] solution_1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public int[] solution_2(int[] arr, int k) {
        int[] r = new int[k];
        quickSort(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k && i < arr.length; i++) {
            r[i] = arr[i];
        }
        return r;
    }

    private void quickSort(int[] arr, int s, int e, int k) {
        if (s < e) {
            int pivot = parition(arr, s, e);
            quickSort(arr, s, pivot - 1, k);
            if (pivot >= k) return;
            quickSort(arr, pivot + 1, e, k);
        }
    }

    private int parition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && pivot <= arr[hi]) hi--;
            arr[lo] = arr[hi];
            while (lo < hi && pivot > arr[lo]) lo++;
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }
}
