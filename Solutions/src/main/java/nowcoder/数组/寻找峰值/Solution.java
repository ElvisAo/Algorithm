package nowcoder.数组.寻找峰值;

public class Solution {
    public static void main(String[] args) {

    }

    public int solve(int[] a) {
        if (a.length == 1) return 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1 && a[i] > a[i - 1]) return i;
            if (i == 0 && a[i] > a[i + 1]) return i;
            if (i != 0 && i != a.length - 1 && a[i] > a[i + 1] && a[i] > a[i - 1]) return i;
        }
        return -1;
    }
}
