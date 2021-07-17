package nowcoder.动态规划.子数组最大乘积;

public class Solution {
    public static void main(String[] args) {

    }

    public double solution_1(double[] arr) {
        if (arr == null || arr.length == 0) return 0.0;
        if (arr.length == 1) return arr[0];
        double r = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                double m = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    m *= arr[k];
                }
                r = Math.max(r, m);
            }
        }
        return r;
    }

    /**
     * TODO 没有完全搞明白
     *
     * @param arr
     * @return
     */
    public double solution_2(double[] arr) {
        double maxVal = arr[0];     // 局部最大值
        double minVal = arr[0];     // 局部最小值
        double res = arr[0];    // 全局最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                double tmp = maxVal;
                maxVal = minVal;
                minVal = tmp;
            }

            maxVal = Math.max(arr[i], arr[i] * maxVal);
            minVal = Math.min(arr[i], arr[i] * minVal);
            res = Math.max(res, maxVal);
        }
        return res;
    }

    /**
     * {@动态规划，类似求最大区间和或求连续递增子序列，只是除了记录最大值，还要记录最小值}
     *
     * @param arr
     * @return
     */
    public double solution_3(double[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        double[] maxv = new double[n];
        double[] minv = new double[n];
        double r = arr[0];
        maxv[0] = arr[0];
        minv[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                maxv[i] = Math.max(arr[i], arr[i] * minv[i - 1]);
                minv[i] = Math.min(arr[i], arr[i] * maxv[i - 1]);
            } else {
                maxv[i] = Math.max(arr[i], arr[i] * maxv[i - 1]);
                minv[i] = Math.min(arr[i], arr[i] * minv[i - 1]);
            }
            r = Math.max(r, maxv[i]);
        }
        return r;
    }
}
