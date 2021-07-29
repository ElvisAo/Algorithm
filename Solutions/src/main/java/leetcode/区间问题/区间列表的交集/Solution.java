package leetcode.区间问题.区间列表的交集;

import java.util.Arrays;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 ||
                secondList == null || secondList.length == 0) return new int[0][2];
        int[][] res = new int[firstList.length + secondList.length][2];
        int resIndex = 0, fIndex = 0, sIndex = 0;
        while (fIndex < firstList.length && sIndex < secondList.length) {
            int a0 = firstList[fIndex][0], a1 = firstList[fIndex][1];
            int b0 = secondList[sIndex][0], b1 = secondList[sIndex][1];
            if (a1 >= b0 && b1 >= a0) {   // 有交集
                res[resIndex][0] = Math.max(a0, b0);
                res[resIndex][1] = Math.min(a1, b1);
                resIndex++;
            }
            if (b1 < a1) sIndex++;
            else fIndex++;
        }
        int[][] r = Arrays.copyOf(res, resIndex);
        return r;
    }
}