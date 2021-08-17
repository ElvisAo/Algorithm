package leetcode.动态规划.一到n中一的出现次数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_4(100));
    }

    /**
     * {@动态规划：计算到i时，i/10已经被计算出来了}
     *
     * @param n
     * @return
     */
    public int solution_1(int n) {
        int[] dp = new int[n + 1];
        int r = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 10] + (i % 10 == 1 ? 1 : 0);
            r += dp[i];
        }
        return r;
    }

    /**
     * {@暴力}
     *
     * @param n
     * @return
     */
    public int solution_2(int n) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j > 0) {
                r += (j % 10 == 1) ? 1 : 0;
                j /= 10;
            }
        }
        return r;
    }

    /**
     * {@优化solution_1}
     *
     * @param n
     * @return
     */
    public int solution_3(int n) {
        int[] dp = new int[n / 100 + 1];
        int r = 0;
        for (int i = 1; i <= n / 100; i++) {
            int t = i % 100;
            dp[i] = dp[i / 100];
            while (t > 0) {
                dp[i] += (((t % 10) == 1) ? 1 : 0);
                t /= 10;
            }
            r += dp[i];
        }
        for (int i = n / 100 + 1; i <= n; i++) {
            r += dp[i / 100];
            int t = i % 100;
            while (t > 0) {
                r += (((t % 10) == 1) ? 1 : 0);
                t /= 10;
            }
        }
        return r;
    }

    /**
     * {@动态规划：不仅是除了的已经被计算了，后面被模的可能也被计算了,因此，可以将数字对半分}
     *
     * @param n
     * @return
     */
    public int solution_4(int n) {
        // 上一级递归 n = 20、10之类的整十整百之类的情况；以及n=0的情况
        if (n == 0) return 0;
        // n < 10 即为个位，这样子只有一个1
        if (n < 10) return 1;

        String s = String.valueOf(n);
        //长度：按例子来说是4位
        int length = s.length();

        //这个base是解题速度100%的关键，本例中的是999中1的个数：300
        // 9的话就是1 ；99的话就是20 ; 9999就是4000 这里大家应该发现规律了吧。
        int base = (length - 1) * (int) Math.pow(10, length - 2);

        //high就是最高位的数字
        int high = s.charAt(0) - '0';
        //cur就是当前所数量级，即1000
        int cur = (int) Math.pow(10, length - 1);
        if (high == 1) {
            //最高位为1，1+n-cur就是1000~1234中由千位数提供的1的个数，剩下的f函数就是求1000~1234中由234产生的1的个数
            return base + 1 + n - cur + solution_4(n - high * cur);
        } else {
            //这个自己思考
            return base * high + cur + solution_4(n - high * cur);
        }
    }
}
