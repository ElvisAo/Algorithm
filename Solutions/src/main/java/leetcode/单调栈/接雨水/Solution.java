package leetcode.单调栈.接雨水;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(heights));
    }

    public long trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        return helper(height);
    }

    private long helper(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        ArrayList<Integer> r = new ArrayList<>();
        int[] rh = new int[arr.length];
        ArrayList<Integer> l = new ArrayList<>();
        int[] lh = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // l
            while (!l.isEmpty() && l.get(l.size() - 1) <= arr[i]) {
                l.remove(l.size() - 1);
            }
            lh[i] = l.isEmpty() ? -1 : l.get(0);
            l.add(arr[i]);
            //l
            int j = arr.length - i - 1;
            while (!r.isEmpty() && r.get(r.size() - 1) <= arr[j]) {
                r.remove(r.size() - 1);
            }
            rh[j] = r.isEmpty() ? -1 : r.get(0);
            r.add(arr[j]);
        }

        long res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (rh[i] != -1 && lh[i] != -1) {
                int minH = Math.min(rh[i], lh[i]);
                res += minH - arr[i];
            }
        }
        return res;
    }
}
