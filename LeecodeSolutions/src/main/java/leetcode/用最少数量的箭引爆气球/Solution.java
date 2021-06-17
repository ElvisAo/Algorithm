package leetcode.用最少数量的箭引爆气球;

import preprocess.FileUtils;
import preprocess.ScannerUtils;

import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileUtils.replaceChar("E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\leetcode.用最少数量的箭引爆气球\\input.txt", ' ', ',', '[', ']');
        int[][] r = ScannerUtils.scanner2dMatrixInteger(2, 2, "E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\leetcode.用最少数量的箭引爆气球\\input.txt");
        System.out.println(new Solution().findMinArrowShots(r));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> {
            if (x[1] > y[1]) return 1;
            else return -1;
        });
        int counter = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                counter++;
            }
        }
        return counter;
    }
}
