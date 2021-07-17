package nowcoder.数组.旋转数组;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a) {
        if (m % n == 0) return a;
        m %= n;
        int[] r = new int[n];
        int ri = 0;
        for (int i = n - m; i < n; i++) {
            r[ri++] = a[i];
        }
        for (int i = 0; i < n - m; i++) {
            r[ri++] = a[i];
        }
        return r;
    }
}
