package nowcoder.排序.寻找第K大;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2};
        int K = 3;
        System.out.println(new Solution().findKth(a, a.length, K));
    }

    public int findKth(int[] a, int n, int K) {
        quickSort(a, 0, n - 1, K - 1);
        return a[K - 1];
    }

    private void quickSort(int[] a, int s, int e, int K) {
        if (s < e) {
            int pivot = partition(a, s, e);
            quickSort(a, s, pivot - 1, K);
            if (pivot >= K) return;
            quickSort(a, pivot + 1, e, K);
        }
    }

    private int partition(int[] a, int s, int e) {
        int pivot = a[s];
        while (s < e) {
            while (s < e && pivot >= a[e]) e--;
            a[s] = a[e];
            while (s < e && pivot < a[s]) s++;
            a[e] = a[s];
        }
        a[s] = pivot;
        return s;
    }
}
