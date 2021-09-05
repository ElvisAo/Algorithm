package leetcode.数学.快乐数;

import java.util.HashSet;

/**
 * leetcode 202
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }

    HashSet<Integer> memo = new HashSet<>();

    public boolean isHappy(int n) {
        if (memo.contains(n)) return false;
        memo.add(n);
        int t = 0;
        while (n > 0) {
            t += (n % 10) * (n % 10);
            n /= 10;
        }
        if (t == 1) return true;
        return isHappy(t);
    }

    /**
     * 快慢指针，快的最后会追上慢的
     *
     * @param n
     * @return
     */
    public boolean solution_2(int n) {
        int slow = n, fast = n, t;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (fast != 1 && slow != fast);
        return slow != fast;
    }

    private int square(int n) {
        int t = 0;
        while (n > 0) {
            t += (n % 10) * (n % 10);
            n /= 10;
        }
        return t;
    }
}
