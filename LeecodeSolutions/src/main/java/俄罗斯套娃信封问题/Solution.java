package 俄罗斯套娃信封问题;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] envlops = new int[14][2];
        Scanner scanner = new Scanner(new FileInputStream("E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\俄罗斯套娃信封问题\\input.txt"));
        for (int i = 0; i < 14; i++) {
            envlops[i][0] = scanner.nextInt();
            envlops[i][1] = scanner.nextInt();
        }
        System.out.println(new Solution().maxEnvelopes(envlops));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, y) ->
                x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]
        );
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        // patience sorting求最长递增子序列
        int[] top = new int[heights.length];
        int piles = 0;
        for (int i = 0; i < heights.length; i++) {
            int poker = heights[i];
            int left = 0, right = piles;    // right取不到，所以最后的piles就是最长递增子序列的长度
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (top[mid] >= poker) right = mid;
                else left = mid + 1;
            }
            if (left == piles) piles++;
            top[left] = poker;  // 注意：这里是left
        }
        return piles;
    }
}
