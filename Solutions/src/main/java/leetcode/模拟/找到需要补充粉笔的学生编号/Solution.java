package leetcode.模拟.找到需要补充粉笔的学生编号;

/**
 * leetcode 1894
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5};
        int k = 22;
        System.out.println(new Solution().chalkReplacer(arr, k));
    }

    public int chalkReplacer(int[] chalk, int k) {
        int r = -1, n = chalk.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += chalk[i];
        k = (int) ((long) k % sum);
        while (r == -1) {
            for (int i = 0; i < n; i++) {
                if (k < chalk[i]) {
                    r = i;
                    break;
                } else {
                    k -= chalk[i];
                }
            }
        }
        return r;
    }
}
