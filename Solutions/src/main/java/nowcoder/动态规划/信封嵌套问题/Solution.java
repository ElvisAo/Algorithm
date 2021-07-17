package nowcoder.动态规划.信封嵌套问题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] letters = {{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
        System.out.println(new Solution().maxLetters(letters));
    }

    public int maxLetters(int[][] letters) {
        Arrays.sort(letters, (x, y) -> {    // 按照宽度升序、高度降序排列，从而将问题转换为求高度的最长递增子序列问题
            if (x[0] == y[0]) return y[1] - x[1];
            else return x[0] - y[0];
        });
        int ln = letters.length;
        int[] heights = new int[ln];
        for (int i = 0; i < ln; i++) heights[i] = letters[i][1];
        /**
         * 下面开始求LIS
         * {@使用patience-sorting，牌堆顶是从小到大排列的}
         */
        int[] piles = new int[ln];
        int left = 0, right = 0, index = 0, mid;
        for (int i = 0; i < ln; i++) {
            int poker = heights[i];
            left = 0;
            right = index;
            while (left < right) {  // 左闭右开，右侧不可取
                mid = left + ((right - left) >> 1);
                if (piles[mid] == poker) right = mid;   // 如果相同了，因为是寻找左边界，所以还是往左走
                else if (piles[mid] > poker) right = mid;  // 牌堆顶的大
                else left = mid + 1;       // 牌堆顶的小于等与
            }
            if (left == index) index++;
            piles[left] = poker;

        }
        return index;
    }

}
