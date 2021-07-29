package leetcode.区间问题.无重叠区间;

import preprocess.FileUtils;
import preprocess.ScannerUtils;

import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileUtils.replaceChar("E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\leetcode.无重叠区间\\input.txt", ' ',',', '[', ']');
        int[][] m = ScannerUtils.scanner2dMatrixInteger(4, 2, "E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\leetcode.无重叠区间\\input.txt");
        System.out.println(new Solution().eraseOverlapIntervals(m));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        int counter = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                counter++;
            }
        }
        return intervals.length - counter;
    }
}
