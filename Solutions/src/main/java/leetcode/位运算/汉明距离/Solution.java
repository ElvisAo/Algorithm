package leetcode.位运算.汉明距离;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int mask = 1, r = 0;
        while (x > 0 && y > 0) {
            if ((x & mask) != (y & mask)) r++;
            x >>= 1;
            y >>= 1;
        }
        while (x > 0) {
            if ((mask & x) == 1)
                r++;
            x >>= 1;
        }
        while (y > 0) {
            if ((mask & y) == 1)
                r++;
            y >>= 1;
        }
        return r;
    }
}
