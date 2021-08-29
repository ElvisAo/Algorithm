package leetcode.贪心.加油站;

/**
 * leetcode 134
 */
public class Solution {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new Solution().solution_1(gas, cost));
    }

    public int solution_1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (reachable(i, gas, cost)) return i;
        }
        return -1;
    }

    private boolean reachable(int start, int[] gas, int[] cost) {
        int g = 0;
        for (int i = start; i < start + gas.length; i++) {
            g += gas[i % gas.length];
            g -= cost[i % cost.length];
            if (g < 0) return false;
        }
        return true;
    }

    /**
     * {@图像解法：把行车过程中的油在每个站点时的多少用图画出来，则存在一个最低点，如果从这个最低点出发，都能够到转一圈的话，则可以}
     *
     * @param gas
     * @param cost
     * @return
     */
    public int solution_2(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0, minSum = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i;
                minSum = sum;
            }
        }
        if (sum < 0) return -1; // 总油量小于消耗量，无解
        /**
         * 否则有解，从图中的最低点出发
         * {@为什么判断start==n?环形数组的特性}
         */
        return start == n ? 0 : start;
    }

    /**
     * {@贪心：假设到i出发，到了j，油箱中的油量恰好小于0，则从i到j之前的站的出发也不行}
     * 考虑“恰好“，则意味者从i-j中的某个站点k，从i到k时，油量是大于0的，而从k出发到j，油量是等于0的，大于0都无法到达，则等于0更无法到达
     *
     * @param gas
     * @param cost
     * @return
     */
    public int solution_3(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        int tank = 0;   // 油箱中的油量
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return start == n ? -1 : start;
    }
}
