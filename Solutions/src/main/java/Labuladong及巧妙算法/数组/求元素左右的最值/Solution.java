package Labuladong及巧妙算法.数组.求元素左右的最值;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 3, 2, 4, 67, 8, 56, 5, 4};
        int[][] r = new Solution().leftMinRightMax(arr);
        for (int i = 0; i < r.length; i++) {
            System.out.printf(r[i][0] + " ");
        }
        System.out.println();
        for (int i = 0; i < r.length; i++) {
            System.out.printf(r[i][1] + " ");
        }
    }

    /**
     * 求左边的最小值和右边的最大值
     *
     * @param arr
     * @return
     */
    public int[][] leftMinRightMax(int[] arr) {
        int n = arr.length;
        int[][] r = new int[n][2];  // 0：最小值，1：最大值
        int minVal = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || minVal > arr[i]) {
                minVal = arr[i];
                minIndex = i;
            }
            r[i][0] = minVal;
        }
        int maxVal = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || maxVal < arr[i]) {
                maxVal = arr[i];
                maxIndex = i;
            }
            r[i][1] = maxVal;
        }
        return r;
    }
}
