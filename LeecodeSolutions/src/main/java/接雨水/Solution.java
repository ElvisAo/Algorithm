package 接雨水;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(heights));
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        return helper(height);
    }

    private int helper(int[] height) {
        ArrayList<Integer> r = new ArrayList<>();
        int[] rh = new int[height.length];
        ArrayList<Integer> l = new ArrayList<>();
        int[] lh = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            // l
            while (!l.isEmpty() && height[l.get(l.size() - 1)] <= height[i]) {
                l.remove(l.size() - 1);
            }
            lh[i] = l.isEmpty() ? -1 : height[l.get(0)];
            l.add(i);
            //l
            int j = height.length - i - 1;
            while (!r.isEmpty() && height[r.get(r.size() - 1)] <= height[j]) {
                r.remove(r.size() - 1);
            }
            rh[j] = r.isEmpty() ? -1 : height[r.get(0)];
            r.add(j);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (rh[i] != -1 && lh[i] != -1) {
                int minH = Math.min(rh[i], lh[i]);
                res += minH - height[i];
            }
        }
        return res;
    }
}
