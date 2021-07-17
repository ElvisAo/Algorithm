package nowcoder.数学.回文数字;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12112));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int n = ("" + x).length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int hi = x % (int) (Math.pow(10, n - i));
            hi /= (int) Math.pow(10, n - i - 1);

            int low = x % (int) Math.pow(10, n - j);
            low /= (int) Math.pow(10, n - j - 1);
            if (low != hi) return false;
        }
        return true;
    }
}
