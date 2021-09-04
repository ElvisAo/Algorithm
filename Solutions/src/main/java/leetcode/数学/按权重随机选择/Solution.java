package leetcode.数学.按权重随机选择;

import java.util.Random;

/**
 * leetcode 528
 */
public class Solution {
    public static void main(String[] args) {

    }

    int[] preSum, val;
    int n, totalSum;

    public Solution(int[] w) {
        n = w.length;
        val = w;
        preSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) preSum[i] = w[i];
            else preSum[i] = preSum[i - 1] + w[i];
        }
        totalSum = preSum[n - 1];
    }

    /**
     * for的意义：eg：对于[1,3]，preSum = {1,4};
     * 生成的随机数为1~4，如果是1，返回0；如果是2，3，4，返回1
     * 即，对于当前生成的随机数pos，如果pos>preSum[i-1] && pos <= preSum[i]，则应该返回i
     *
     * @return
     */
    public int pickIndex() {
        Random random = new Random();
        int pos = random.nextInt(totalSum) + 1;
        int r = -1;
        // 下面这个可以用二分来优化
        for (int i = 0; i < n; i++) {
            if (pos <= preSum[i]) {
                r = i;
                break;
            }
        }
        return r;
    }
}
