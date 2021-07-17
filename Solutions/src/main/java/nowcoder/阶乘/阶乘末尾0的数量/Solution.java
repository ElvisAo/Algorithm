package nowcoder.阶乘.阶乘末尾0的数量;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_1(5));
    }

    /**
     * {@暴力-超时}
     *
     * @param n
     * @return
     */
    public long solution_1(long n) {
        long m = 1;
        for (int i = 1; i <= n; i++) m *= i;
        String s = m + "";
        long r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') return r;
            else r++;
        }
        return r;
    }

    /**
     * {@拆5}
     *
     * @param n
     * @return
     */
    public long solution_2(long n) {
        long num = 0;
        long five = 5;
        while (n >= five) {
            num += n / five;
            five *= 5;
        }
        return num;
    }
}
