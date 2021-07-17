package nowcoder.数学.最大公约数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().gcd(10, 5));
    }

    public int gcd(int a, int b) {
        if (Math.min(a, b) == 0) return Math.max(a, b);
        if (a > b) {    // 确保a小b大
            int t = a;
            a = b;
            b = t;
        }
        return gcd(b % a, a);
    }
}
