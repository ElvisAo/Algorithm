package nowcoder.哈希.未排序数组中累加和为给定值的最长子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 3};
        int k = 6;
        System.out.println(new Solution().solution_2(t, k));
    }

    /**
     * {@暴力-超时}
     *
     * @param arr
     * @param k
     * @return
     */
    public int solution_1(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length, ln = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int t = i; t <= j; t++) {
                    sum += arr[t];
                }
                if (sum == k) {
                    ln = Math.max(ln, j - i + 1);
                }
            }
        }
        return ln;
    }

    /**
     * {@哈希+前缀和}
     *
     * @param arr
     * @param k
     * @return
     */
    public int solution_2(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0, ln = 0, n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);     // 避免漏掉以首元素开始的子数组，比如 1，2，3，3；k=6
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                ln = Math.max(ln, i - map.get(sum - k));
            }
            if (!map.containsKey(sum))  // 必须要判断
                map.put(sum, i);
        }
        return ln;
    }
}
