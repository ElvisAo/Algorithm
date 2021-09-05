package leetcode.数组.分发糖果;


import java.util.Arrays;

/***
 * leetcode 138
 */
public class Solution {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 3};
        System.out.println(new Solution().candy(ratings));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] r = new int[n];
        Arrays.fill(r, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) r[i] = r[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) r[i] = Math.max(r[i], r[i + 1] + 1);
        }
        return Arrays.stream(r).sum();
    }
}
