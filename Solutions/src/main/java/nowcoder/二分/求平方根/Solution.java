package nowcoder.二分.求平方根;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sqrt(1518991037));
    }

    /**
     * {@注意：为了避免溢出，加法可以转为减法来做，乘法可以转为除法来做}
     *
     * @param x
     * @return
     */
    public int sqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, mid;
        while (true) {
            mid = left + ((right - left) >> 1);
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if (mid < x / mid) left = mid + 1;
            else if (mid > x / mid) right = mid - 1;
        }
    }
}
