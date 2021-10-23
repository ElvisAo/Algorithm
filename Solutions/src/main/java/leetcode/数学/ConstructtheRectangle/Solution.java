package leetcode.数学.ConstructtheRectangle;

import java.util.Arrays;

/**
 * leetcode 492
 */
public class Solution {
    public static void main(String[] args) {
        int area = 8;
        System.out.println(Arrays.toString(new Solution().constructRectangle(area)));
    }

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area), l = w;
        int[] res = new int[2];
        int multi = w * l;
        while (multi != area) {
            if (multi < area) l++;
            else w--;
            multi = w * l;
        }
        res[0] = l;
        res[1] = w;
        return res;
    }

    public int[] solution_2(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area / w, w};
    }
}
