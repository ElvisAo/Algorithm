package 戳气球;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\戳气球\\input.txt"));
        String[] split = scanner.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(new Solution().solution_2(nums));
    }

    private int res;

    public int solution_1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        backtrack(list, 0);
        return res;
    }

    private void backtrack(ArrayList<Integer> list, int score) {
        if (list.size() == 0) res = Math.max(res, score);
        else {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                int point = (i - 1 < 0 ? 1 : list.get(i - 1)) * n * (i + 1 > list.size() - 1 ? 1 : list.get(i + 1));
                ArrayList<Integer> t = new ArrayList<>(list);
                t.remove(i);
                backtrack(t, score + point);
            }
        }
    }

    /*************上面的为回溯法：超时***************/
    private int solution_2(int[] nums) {
        int ln = nums.length;
        int[] p = new int[ln + 2];
        p[0] = 1;
        p[ln + 1] = 1;
        for (int i = 1; i < ln + 1; i++) p[i] = nums[i - 1];

        int[][] dp = new int[ln + 2][ln + 2];
        for (int i = ln; i >= 0; i--) {
            for (int j = i + 1; j < ln + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + p[i] * p[k] * p[j]);
                }
            }
        }
        return dp[0][ln + 1];
    }

}
