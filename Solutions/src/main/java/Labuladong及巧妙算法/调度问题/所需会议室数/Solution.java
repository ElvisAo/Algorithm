package Labuladong及巧妙算法.调度问题.所需会议室数;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        // 再用双指针技巧扫描一遍
        int counter = 0, res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {    // 遇到一个开始时间
                counter++;
                i++;
            } else {    // 遇到一个结束时间
                counter--;
                j++;
            }
            res = Math.max(res, counter);
        }
        return res;
    }
}
